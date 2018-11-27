
package lazybones.services;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Anmol
 */
public class SummaryAccuracyTesting {
    Map<String,Double> system=new HashMap();
  Map<String,Double> user=new HashMap();

    public  void SummaryAccuracyTesting(String path) throws IOException{
    use();
   sys(path);

    }
    public   void sys(String path) throws IOException{
        String summary=path.replace(".txt","_summary.txt");
String file=summary;
//task1_englishSyssum1.txt

String s = "";
        String line = "";
       Vector lines_all=new Vector(3,2);
        
            Vector v=new Vector(3,2);
            FileReader fileReader = new FileReader(file);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);
           while ((s = bufferedReader.readLine()) != null) {

                s = s.trim();
                for (int i = 0; i < s.length(); i++) {

                     if (((s.charAt(i) >='A') && (s.charAt(i) <= 'Z'))||((s.charAt(i) >='a') && (s.charAt(i) <= 'z'))||(s.charAt(i)==' ')) {
                        line = line + s.charAt(i);
                    }
                    
                }
                line = line + " ";
                lines_all.add(line);
            }
           bufferedReader.close(); 
           line = line.toLowerCase();
                       //System.out.println(line);
            String w[] = line.split(" ");
            //System.out.println("");
            //System.out.println("length ---" + w.length);
            for (int j = 0; j < w.length; j++) {
                v.add(w[j]);
                
            }

String check="";
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
            
            if(system.containsKey(check)==true){
            system.put(check.trim(),(system.get(check))+1.0);
            }
            else {
            system.put(check.trim(),1.0);
                } 
                  }
                     check=" ";
               }
            }
            
            
        Set set = system.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      double match=0.0;
      double total=0.0;
      while(i.hasNext()) {
      total++;
          Map.Entry me = (Map.Entry)i.next();
          if(user.containsKey(me.getKey().toString())==true){
          match++;
          }
           }
      match=(match*100.00)/total;
     // System.out.println("Accuracy-  "+match);


}
    
    public void use() throws FileNotFoundException, IOException{
String file="C:\\Users\\DELL\\Desktop\\PSO\\Internship\\UseSummary.txt";
//task1_englishSyssum1.txt

String s = "";
        String line = "";
       Vector lines_all=new Vector(3,2);
        
            Vector v=new Vector(3,2);
            FileReader fileReader = new FileReader(file);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);
           while ((s = bufferedReader.readLine()) != null) {

                s = s.trim();
                for (int i = 0; i < s.length(); i++) {

                     if (((s.charAt(i) >='A') && (s.charAt(i) <= 'Z'))||((s.charAt(i) >='a') && (s.charAt(i) <= 'z'))||(s.charAt(i)==' ')) {
                        line = line + s.charAt(i);
                    }
                    
                }
                line = line + " ";
                lines_all.add(line);
            }
           bufferedReader.close(); 
           line = line.toLowerCase();
                       //System.out.println(line);
            String w[] = line.split(" ");
            //System.out.println("");
            //System.out.println("length ---" + w.length);
            for (int j = 0; j < w.length; j++) {
                v.add(w[j]);
                
            }

String check="";
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
            
            if(user.containsKey(check)==true){
            user.put(check.trim(),(user.get(check))+1.0);
            }
            else {
            user.put(check.trim(),1.0);
                } 
                  }
                     check=" ";
               }
            }
}
}
