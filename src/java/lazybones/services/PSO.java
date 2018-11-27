package lazybones.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class PSO
{
    private static final Double TARGET = 50.0;
    private static  int MAX_INPUTS = 2;
    private static int MAX_PARTICLES = 4;
    private static final int V_MAX = 10;             // Maximum velocity change allowed.

    private static final int MAX_EPOCHS = 10;
    // The particles will be initialized with data randomly chosen within the range
    // of these starting min and max values: 
    private static final int START_RANGE_MIN = 0;
    private static final int START_RANGE_MAX = 4;
static Vector lines=new Vector(3,2);
static Vector rt=new Vector(3,2);
    private static ArrayList<Particle> particles = new ArrayList<Particle>();
    
    private static void initialize(String path,int size1) throws FileNotFoundException, IOException
    {///////////////////////
          
   int size=size1;  
        System.out.println(path);
        String s=path;
String previous_file_read="C:\\Users\\DELL\\Desktop\\PSO\\Internship\\review_old.txt";
String previous_file_write="C:\\Users\\DELL\\Desktop\\PSO\\Internship\\review_old1.txt";
//s=in.nextLine();
Info info=new Info();
info.Info(previous_file_read, previous_file_write);
Pre p=new Pre();
    p.Pre(s,previous_file_write);
        
        Vector score=new Vector(3,2);
         FileReader fileReader = new FileReader("C:\\Users\\DELL\\Desktop\\PSO\\Internship\\Pso_lines_score.txt");
            // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
                int li=0;
                while ((s = bufferedReader.readLine()) != null) {
                li++;
                s = s.trim();
                int i=s.lastIndexOf(" ");
                //System.out.println("i-- "+i);
                if(i>-1){
                lines.add(s.substring(0,i));
                score.add(s.substring(i+1));
                }}
                MAX_PARTICLES=li;
                MAX_INPUTS=(size*li)/100;
               // System.out.println("li---  "+li);
                bufferedReader.close();
        //System.out.println("we- "+score.size());
      // Subsets sub=new Subsets();
        //Vector subs=sub.Subsets(MAX_INPUTS,lines.size());
        ///////////////////////
        //System.out.println(""+subs.get(size-1));        
        //System.out.println(MAX_INPUTS+" "+MAX_PARTICLES+" "+lines.size()+" "+score.size());
        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            Particle newParticle = new Particle();
            Double total = 0.0;
            Vector ui=new Vector();
            for(int j = 0; j < MAX_INPUTS; j++)
            {
              // System.out.println("yuio------   "+lines.get(j));
                ui.add(lines.get(j));
                //newParticle.data(j, Double.parseDouble(score.get(getRandomNumber(START_RANGE_MIN, START_RANGE_MAX)).toString()));
                 newParticle.data(j, Double.parseDouble(score.get(j).toString()));
        
                total += newParticle.data(j);
                if(j==(MAX_INPUTS-1)){
                score.add(score.get(0));
                score.remove(0);
                lines.add(lines.get(0));
                lines.remove(0);
                
                }
            
            }
            rt.add(ui);// j
            newParticle.pBest(total);
            particles.add(newParticle);
        } // i
        return;
    }
    
    private static void PSOAlgorithm(String path,int size1) throws IOException
    {
        int gBest = 0;
        int gBestTest = 0;
        Particle aParticle = null;
        int epoch = 0;
        boolean done = false;

        initialize(path,size1);

        while(!done)
        {
            // Two conditions can end this loop:
            //    if the maximum number of epochs allowed has been reached, or,
            //    if the Target value has been found.
            if(epoch < MAX_EPOCHS){

                for(int i = 0; i < MAX_PARTICLES; i++)
                {
                    aParticle = particles.get(i);
                    for(int j = 0; j < MAX_INPUTS; j++)
                    {
                        if(j < MAX_INPUTS - 1){
                    //        System.out.print(aParticle.data(j) + " + ");
                        }else{
                  //          System.out.print(aParticle.data(j) + " = ");
                        }
                    } // j

                //    System.out.print(testProblem(i)+ "\n");
                    if(testProblem(i) == TARGET){
                        done = true;
                    }
                } // i

                gBestTest = minimum();
                aParticle = particles.get(gBest);
                // if(any particle's pBest value is better than the gBest value, make it the new gBest value.
                if(Math.abs(TARGET - testProblem(gBestTest)) < Math.abs(TARGET - testProblem(gBest))){
                    gBest = gBestTest;
                }

                getVelocity(gBest);

                updateparticles(gBest);
                
               // System.out.println("epoch number: " + epoch);

                epoch += 1;

            }else{
                done = true;
            }
        }
        return;
    }
    
    private static void getVelocity(int gBestindex)
    {
    //  from Kennedy & Eberhart(1995).
    //    vx[][] = vx[][] + 2 * rand() * (pbestx[][] - presentx[][]) + 
    //                      2 * rand() * (pbestx[][gbest] - presentx[][])

        Double testResults = 0.0;
        Double bestResults = 0.0;
        double vValue = 0.0;
        Particle aParticle = null;

        bestResults = testProblem(gBestindex);

        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            testResults = testProblem(i);
            aParticle = particles.get(i);
            vValue = aParticle.velocity() + 2 * new Random().nextDouble() * (aParticle.pBest() - testResults) + 2 * new Random().nextDouble() * (bestResults - testResults);

            if(vValue > V_MAX){
                aParticle.velocity(V_MAX);
            }else if(vValue < -V_MAX){
                aParticle.velocity(-V_MAX);
            }else{
                aParticle.velocity(vValue);
            }
        }
        return;
    }
    
    private static void updateparticles(int gBestindex)
    {
        Particle gBParticle = particles.get(gBestindex);

        for(int i = 0; i < MAX_PARTICLES; i++)
        {
            for(int j = 0; j < MAX_INPUTS; j++)
            {
                if(particles.get(i).data(j) != gBParticle.data(j)){
                    particles.get(i).data(j, particles.get(i).data(j) + (int)Math.round(particles.get(i).velocity()));
                }
            } // j

            // Check pBest value.
            Double total = testProblem(i);
            if(Math.abs(TARGET - total) < particles.get(i).pBest()){
                particles.get(i).pBest(total);
            }

        } // i
        return;
    }
    
    private static Double testProblem(int index)
    {
        Double total = 0.0;
        Particle aParticle = null;

        aParticle = particles.get(index);

        for(int i = 0; i < MAX_INPUTS; i++)
        {
            
            total += aParticle.data(i);
        }
        return total;
    }
    
    private static void printSolution(String path) throws IOException
    {
        // Find solution particle.
        int i = 0;
        for(; i < particles.size()-1; i++)
        {
            if((testProblem(i) >= TARGET-2)){
                break;
            }
        }
        // Print it.
        //System.out.println("Particle " + i + " has achieved target.");
      //System.out.println(""+lines.size());
      //System.out.println("rt--  "+rt.size());C:\\Users\\Anmol\\Desktop\\Internship\\SysSummary.txt
        /////////////////////
        String summary=path.replace(".txt","_summary.txt");
         FileWriter fw=new FileWriter(summary);
            BufferedWriter bw=new BufferedWriter(fw);
      // Display elements
     
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
          ///////////////////
      for(int j = 0; j < MAX_INPUTS; j++)
        {
            
               System.out.print(((Vector)rt.get(i)).get(j) + " ");
         bw.write(" "+((Vector)rt.get(i)).get(j) + " .");
         bw.newLine();
                    
           
            //    System.out.print(particles.get(i).data(j) + " = " + TARGET);
                   }
      //bw.newLine();
       bw.close();
      fw.close();
     
      
      int y=MAX_INPUTS;
       /*for(int r=1;r<=y;r++){
           
        System.out.print(""+lines.get(i-r)+" ");
       }*/
      // System.out.println("");
        for(int j = 0; j < MAX_INPUTS; j++)
        {
            if(j < MAX_INPUTS - 1){
        //        System.out.print(particles.get(i).data(j) + " + ");
            }else{
          //      System.out.print(particles.get(i).data(j) + " = " + TARGET);
            }
        } // j
       // System.out.print("\n");
        return;
    }
    
    private static int getRandomNumber(int low, int high)
    {
        return (int)((high - low) * new Random().nextDouble() + low);
    }
    
    private static int minimum()
    {
    // Returns an array index.
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            for(int i = 0; i < MAX_PARTICLES; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    // The minimum has to be in relation to the Target.
                    if(Math.abs(TARGET - testProblem(i)) < Math.abs(TARGET - testProblem(winner))){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }

            if(foundNewWinner == false){
                done = true;
            }
        }

        return winner;
    }
    
    private static class Particle
    {
        private Double mData[] = new Double[MAX_INPUTS];
        private Double mpBest = 0.0;
        private double mVelocity = 0.0;
    
        public Particle()
        {
            this.mpBest = 0.0;
            this.mVelocity = 0.0;
        }
    
        public Double data(int index)
        {
            if(index<this.mData.length){
            return this.mData[index];
            }
            else{
            return 1.0;
            }
        }
        
        public void data(int index, Double value)
        {
            this.mData[index] = value;
            return;
        }
    
        public Double pBest()
        {
            return this.mpBest;
        }

        public void pBest(Double value)
        {
            this.mpBest = value;
            return;
        }
    
        public double velocity()
        {
            return this.mVelocity;
        }
        
        public void velocity(double velocityScore)
        {
           this.mVelocity = velocityScore;
           return;
        }
    } // Particle
    
    public  void pso(String path,int size1) throws IOException
    {
        PSOAlgorithm(path,size1);
        printSolution(path);
        SummaryAccuracyTesting act=new SummaryAccuracyTesting();
        act.SummaryAccuracyTesting(path);
        return;
    }

}