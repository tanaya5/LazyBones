

package lazybones.services;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.Math.log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Info {

    public void Info(String fileName,String fileWrite) throws FileNotFoundException{
    
    
    String s = "";
        String line = "";
        try {
            Vector v=new Vector(3,2);
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);
        FileWriter fw=new FileWriter(fileWrite);
            BufferedWriter bw=new BufferedWriter(fw);
            while ((s = bufferedReader.readLine()) != null) {

                s = s.trim();
                for (int i = 0; i < s.length(); i++) {

                     if (((s.charAt(i) >='A') && (s.charAt(i) <= 'Z'))||((s.charAt(i) >='a') && (s.charAt(i) <= 'z'))||(s.charAt(i)==' ')) {
                        line = line + s.charAt(i);
                    }
                    
                }
                line = line + " ";
            }
            line = line.toLowerCase();
                       //System.out.println(line);
            String w[] = line.split(" ");
            //System.out.println("");
            //System.out.println("length ---" + w.length);
            for (int j = 0; j < w.length; j++) {
                v.add(w[j]);
                
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
          total_elements+=1.0;            
            
            if(ngram.containsKey(check)==true){
            ngram.put(check,(ngram.get(check))+1.0);
            }
            else {
            ngram.put(check,1.0);
            }  
             }
            check=" ";
               }
            }
            
            
            Set set = ngram.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         //System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
      
         bw.write(me.getKey()+";"+me.getValue());
                    bw.newLine();
    
        }
       bw.write("TotalWords" + ";"+total_elements);
             bw.newLine();
        
        
         bufferedReader.close();
            bw.close();
            fw.close();

        }
        catch(Exception e){
        
        }
    }
    
    
}
