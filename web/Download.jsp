<%-- 
    Document   : Download
    Created on : May 14, 2017, 12:11:22 AM
    
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title> Download </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
        
    </head>
    <body style="background-color: #292626; ">
        <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="UserPanel.jsp">Dashboard</a></li>
                        <li><a href="logout">Log Out</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>
        <div style="float: right; color: white;padding-top: 120px; padding-right: 300px;">
        <%
            if(request.getParameter("path")!=null)
            {
        %>
        <input type="hidden" id="textpath" name="textpath" value="<%=request.getParameter("path")%>">
        <%        
            }
        %>
        
        <h2 style="color: #f9b332">Your File Was Summarized Successfully</h2><br><br><br>
        <label>Click On The Link To Download The Summarized File:</label>
        <a href="javascript:download()">Download</a>
        </div>
        
        <script type="text/javascript">
            function download()
            {
              var path=document.getElementById("textpath").value;
              window.location.href="download?path="+path;
            }
        </script>
         <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "100%";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
    </body>
</html>
