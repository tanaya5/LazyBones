<%-- 
    Document   : ViewSummary
    Created on : May 14, 2017, 1:14:29 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.BufferedReader,java.io.FileReader" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h2 style="color: crimson">Original Text</h2><br><br>
        <%
            String summary=request.getParameter("path");
            String path=summary.replace("_summary.txt",".txt");
            String text="";
            try
            {
               FileReader fr=new FileReader(path);
               BufferedReader br=new BufferedReader(fr);                  //For Reading Line By Line
			String str;
			while((str=br.readLine())!=null)                    
			{                                           
				text=text+str;
			}
             out.println("<label style='width:200px;height:200px'>"+text+"</label><br><br><br><br>");
             br.close();
             fr.close();
             
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        %>
        
        <h2 style="color: crimson">Summarized Text</h2><br><br>
        <%
            String textsum="";
            try
            {
               FileReader fr=new FileReader(summary);
               BufferedReader br=new BufferedReader(fr);                  //For Reading Line By Line
			String str;
			while((str=br.readLine())!=null)                    
			{                                           
				textsum=textsum+str;
			}
             out.println("<label style='width:200px;height:200px'>"+textsum+"</label><br><br>");
            br.close();
             fr.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        %>
    </body>
</html>
