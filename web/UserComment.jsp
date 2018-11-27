<%-- 
    Document   : UserComment
    Created on : May 11, 2017, 4:03:14 PM
    Author     : DELL
--%>

<%@page import="lazybones.services.ManageProfileServices"%>
<%@page import="lazybones.beans.CommentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <style>
.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: relative;
    cursor: pointer;
    background-color: #555;
    color:#fff;
    text-align:center;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    padding: 12px 16px;
    z-index: 1;
}

.dropdown:hover .dropdown-content {
    display: block;
}
.date-time
{
    padding-left: 200px;
    font-size: 13px;
}
</style>
<title> Comments</title>
      <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
    </head>
    <body style="background-color: #292626">
        <span style="font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;" onclick="openNav()">&#9776;</span>
            <div id="mySidenav" class="rightsidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <ul class="full-nav">
                        <li><a href="UserPanel.jsp">Dashboard</a></li>
                        <li><a href="Home.jsp">Log Out</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
            </div>
        <div style="padding-top: 50px; ">
      
        <%
            if(request.getParameter("msg")!=null)
            {
                if(request.getParameter("msg").equals("Failed"))
                {
         %>
         <label style="background-color: red">There Was An Error Posting Your Comment....try Again</label>
         <%
                }
            }
        %>
        <%  
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                ArrayList<CommentBean> al=ManageProfileServices.getUserComments(userid);
            for(int i=0;i<al.size();i++)
            {
                CommentBean objbean=al.get(i);
        %>
        <div style="background-color:#f9b332 ; color: black;" width="50px">
            <b><p><%= objbean.getEmail()%></p></b>
            <label width="50px">
                <p><%= objbean.getComment()%></p></label>
            <div class="date-time"><%= objbean.getComm_date_time()%></div>
        </div>    
        <%
            if(objbean.getReply()!=null)
            {
        %>
        <div style="background-color:#555; color: white;" width="50px">
            <b><p>Admin Reply</p></b>
            <label width="50px">
                <p><%= objbean.getReply()%></p></label>
                <div class="date-time"><%= objbean.getRep_date_time()%></div>
        </div>
        <%
            }

            }
        %>
        
        <br>
        <div class="dropdown">
  <span style="color: orange">Comment</span>
  <div class="dropdown-content">
    <form>
        <input type="text" id="textcomment" >
        <input type="button" onclick="saveComment()" style="background-color:#f9b332 ; color: black;" value="Send">
        </form>
  </div>
</div>
        <br>
      <br>
      <br>
      <br>
      <br>
        <%
            }
        %>
    </body>
    <script>
        function saveComment()
        {
            var comment=document.getElementById("textcomment").value.trim();
            if(comment=="")
            {
                window.alert("Write A Comment");
            }
            else
            {
                window.location.href="savecomment?comment="+comment;
            }
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
</html>
