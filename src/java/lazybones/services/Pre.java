

package lazybones.services;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
//import org.tartarus.snowball.ext.PorterStemmer;

public class Pre {
    
    public void Pre(String fileName, String previousFile) throws FileNotFoundException, IOException{
        
        ////////////////Previous Data/
        Vector score123=new Vector(3,2);
         FileReader fr= new FileReader(previousFile);
            // Always wrap FileReader in BufferedReader.
            BufferedReader br
                    = new BufferedReader(fr);
        String data="";
        Map<String,Double>  previous_data=new HashMap();
        while ((data = br.readLine()) != null) {

                data = data.trim();
            //    System.out.println(data.substring(data.indexOf(" ")).trim());
                
                previous_data.put(data.substring(0,data.indexOf(";")).toLowerCase().trim(),Double.parseDouble(data.substring(data.indexOf(";")+1).trim()));
        //System.out.println("stored---  "+previous_data.get(data.substring(0,data.indexOf(" ")).toLowerCase()));
        }
br.close();
//System.out.println("previous--- "+previous_data.size());    
        
        ////////////////////////////////
       String s = "";
        String line = "";
        Vector lines_all=new Vector(3,2);
        try {
            Vector v=new Vector(3,2);
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);
           while ((s = bufferedReader.readLine()) != null) {

                s = s.trim();
                String kl="";
                for (int i = 0; i < s.length(); i++) {

                     if (((s.charAt(i) >='A') && (s.charAt(i) <= 'Z'))||((s.charAt(i) >='a') && (s.charAt(i) <= 'z'))||(s.charAt(i)==' ')) {
                        line = line + s.charAt(i);
                    kl=kl+s.charAt(i);
                     }
                     else if(s.substring(i, i+1).equals(".")) {
                    
                lines_all.add(kl);
                     kl="";
                             
                     }
                }
                line = line + " ";
                lines_all.add(kl); 
           }
           bufferedReader.close(); 
           line = line.toLowerCase();
                       //System.out.println(line);
            String w[] = line.split(" ");
            //System.out.println("");
            //System.out.println("length ---" + w.length);
            for (int j = 0; j < w.length; j++) {
                v.add(w[j].trim());
              
            }
             String check=" ";
            Map<String, Double> ngram=new HashMap();             
             Double total_elements=0.00;
            for(int i=1;i<4;i++){
               for(int j=0;j<(v.size()-i+1);j++){
                 for(int k=j;k<j+i;k++){
                   check=check +v.elementAt(k)+" "; 
                   }
            
            if ( (check.equals("  ")||check.contains(" be ") ||check.contains(" to ") ||check.contains(" is ") || check.contains(" i ") || check.contains(" am ")|| check.contains(" a ")|| check.contains(" an ")|| check.contains(" the ")  || check.contains(" are ") || check.contains(" was ") 
                        || check.contains(" were ")  || check.contains(" and ")  || check.contains(" there ") || check.contains(" their ")
                        || check.contains(" our ")  || check.contains(" them ") || check.contains(" these ") || check.contains(" those "))==false) 
            {
          total_elements++;            
            
            if(ngram.containsKey(check)==true){
            ngram.put(check.trim(),(ngram.get(check))+1.0);
            }
            else {
            ngram.put(check.trim(),1.0);
                } 
                  }
                     check=" ";
               }
            }
      
          // Get a set of the entries
      Set set = ngram.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      double probability_elements=0.00;
      Double plm=0.0;
      Double kl=0.0;
      Vector kli=new Vector(3,2);
      Vector klp=new Vector(3,2);
      Double lambda=0.6;
      Vector plm_e_step=new Vector(3,2);
      Vector etd=new Vector(3,2);
      Vector etc=new Vector(3,2);
      Vector LL=new Vector(3,2);
      Vector LL_words=new Vector(3,2);
      Double pc=0.0;
      //System.out.println(previous_data.get("TotalWords"));
      //System.out.println("hi1--  "+ngram.size());
      Double previous_total_elements=previous_data.get("totalwords");
      Double etC=0.0;
      Double etD=0.0;
      
      Double ll=0.0;
      while(i.hasNext()) {
      
          Map.Entry me = (Map.Entry)i.next();
       //  System.out.print("il "+me.getKey() + ": ");
         //System.out.println(me.getValue());
     // System.out.println(previous_data.get(me.getKey().toString()));
          if((previous_data.containsKey(me.getKey().toString().trim()))==true){
      //System.out.println("op- ");
              pc=previous_data.get(me.getKey().toString())/previous_total_elements;
               //System.out.println("op- ");
             // System.out.println(pc);
              etD=(total_elements *((previous_data.get(me.getKey().toString())) + Double.parseDouble(me.getValue().toString()))/(total_elements+previous_total_elements))    ;
       etd.add(etD);
             etC=(previous_total_elements *((previous_data.get(me.getKey().toString())) + Double.parseDouble(me.getValue().toString()))/(total_elements+previous_total_elements))    ;
       etc.add(etC);
          ll=2.0*(Double.parseDouble(me.getValue().toString())*log(Double.parseDouble(me.getValue().toString())/etD)+(previous_data.get(me.getKey().toString())*log(previous_data.get(me.getKey().toString())/etC)));
          LL.add(ll);
          LL_words.add(me.getKey().toString());
          }
      else{
            pc=0.0;
            etD=(total_elements *( Double.parseDouble(me.getValue().toString()))/(total_elements+previous_total_elements))    ;
       etd.add(etD);
             etC=(previous_total_elements *( Double.parseDouble(me.getValue().toString()))/(total_elements+previous_total_elements))    ;
       etc.add(etC);
         // System.out.println("op- ");
         // System.out.println("op- ");
          }
          
        //System.out.println("op- ");
          ////////////////////////////////////////
          Double d=0.0;
          Double product=1.0;
          Double p=0.0;
          Double temp=0.0;
         String u[]=me.getKey().toString().trim().split(" ");
         //System.out.println(u.length);
         if(u.length>1){
         for(int y=0;y<u.length;y++){
         //System.out.println("--  "+u.length);
          u[y]=u[y].trim();
          if(u[y].length()>0){
             temp=ngram.get(u[y])/total_elements;
             product=product*temp;
            }
            }
         //System.out.println("--2  "+u.length);
         
         p=Double.parseDouble(me.getValue().toString())/total_elements;
         d=p*log(p/product); 
         klp.add(d);
         }
       //  System.out.println("size=  "+klp.size());
          
          /////////////////////////////////////////////
         
          
          probability_elements=Double.parseDouble(me.getValue().toString())/total_elements;
     
         plm=(Double.parseDouble(me.getValue().toString()) * lambda*probability_elements)/((lambda*probability_elements)+((1-lambda)*pc));
      plm_e_step.add(plm);
      
      kl=probability_elements*log(probability_elements/pc);
      kli.add(kl);
      //System.out.println("op- "+me.getKey() + " : "+plm);
      
      }
      for(int e=0;e<kli.size();e++){
     // System.out.println("kli- "+kli.elementAt(e));
      }
       BufferedWriter bw = null;
		FileWriter fw = null;

            fw = new FileWriter("C:\\Users\\DELL\\Desktop\\PSO\\Internship\\Pso_lines_score.txt");
			bw = new BufferedWriter(fw);
      for(int rt=0;rt<lines_all.size();rt++){
      String h[]=lines_all.get(rt).toString().split(" ");
      Double score=0.00;
      for(int yu=0;yu<h.length;yu++){
      int e=LL_words.indexOf(h[yu].toLowerCase());
      if(e>-1){
      score=score+Double.parseDouble(LL.get(e).toString());
      }
      }
     // System.out.println(score);
      lines_all.set(rt,lines_all.get(rt).toString()+" "+score);
    bw.write(""+lines_all.get(rt).toString());
    bw.newLine();
     // System.out.println(""+lines_all.get(rt));
      
      }
            
              // System.out.println(ngram.size());
             // System.out.println(ngram.keySet());
            //System.out.println(ngram.values());
            
            
          
        //System.out.println(v.size());
            ///////////////////////////////////MultiPhrase//////////////////////////////
          /*  Map<String,Double> multigram =new HashMap();
        for(int l=2;l<4;l++){
               for(int j=0;j<(v.size()-l+1);j++){
                 for(int k=j;k<j+l;k++){
                   check=check +v.elementAt(k)+" "; 
                   }
            
            if ( (check.equals("  ")||check.contains(" be ") ||check.contains(" to ") ||check.contains(" is ") || check.contains(" i ") || check.contains(" am ")|| check.contains(" a ")|| check.contains(" an ")|| check.contains(" the ")  || check.contains(" are ") || check.contains(" was ") 
                        || check.contains(" were ")  || check.contains(" and ")  || check.contains(" there ") || check.contains(" their ")
                        || check.contains(" our ")  || check.contains(" them ") || check.contains(" these ") || check.contains(" those "))==false) 
            {
          total_elements++;            
            
            if(multigram.containsKey(check)==true){
            multigram.put(check.trim(),(multigram.get(check))+1.0);
            }
            else {
            multigram.put(check.trim(),1.0);
            }
            
            }
            
                  check=" ";
               }
            }
         Set se = multigram.entrySet();
      Vector multi=new Vector(3,2);
      // Get an iterator
      Iterator ii = se.iterator();
      Double d=0.0;
      Double product=1.0;
       Double p=0.0;
     while(ii.hasNext()) {
         Map.Entry me = (Map.Entry)ii.next();
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
         Double temp=0.0;
         String u[]=me.getKey().toString().trim().split(" ");
         for(int y=0;y<u.length;y++){
         temp=ngram.get(u[y].trim())/total_elements;
         product=product*temp;
         
         }
         p=Double.parseDouble(me.getValue().toString())/total_elements;
         d=p*log(p/product); 
         multi.add(d);
        
        }
      
        */
        ///////////////////////////////////
        
         bw.close();
       fw.close();
            } catch (Exception e) {
            System.out.println(e);
        }
        
        
    
    }
}
