/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lazybones.services;

import java.util.Vector;

/**
 *
 * @author Anmol
 */
public class Subsets {
    public Vector Subsets(int size,int lines){
        
        
        
        //String s1=""+name[rt];
       
     int n = lines;
        int total=1;
        Vector v = new Vector();
        
        int a[] =new int[n];
        for(int i=0;i<n;i++){
        a[i]=i+1;
        }
        
        
        //System.out.println("{}");
        Vector temp = new Vector();
        for (int i = 0; i < n; i++) {
            temp.add(""+a[i]);
        total++;
                }
        v.add(temp);

        Vector c=new Vector();
            for (int j = 0; j < ((Vector) v.get(0)).size()-1; j++) {
                int t=Integer.parseInt((String) ((Vector) v.get(0)).get(j));
                
               
                for(int k=t+1;k<=a.length;k++){
                c.add(t+" : "+k);
        total++;
        
                }
                
            }
            v.add(c);
            
            for(int i=1;i<a.length-1;i++){
               Vector d=new Vector();
           //  System.out.println(((Vector) v.get(i)).size()-1);
               while(v.size()<size){
                for (int j = 0; j < ((Vector) v.get(i)).size()-1; j++) {
                    
                        String s=(String) ((Vector) v.get(i)).get(j);
                    int t=Integer.parseInt(s.substring(s.lastIndexOf(":")+1).trim());
               
                for(int k=t+1;k<=a.length;k++){
                d.add(s+" : "+k);
                total++;
        
                }
                
                }
                
               v.add(d);
                
            }}
            System.out.println(total);
    System.out.println(v);
        
        
     
    return v;
    }
}
