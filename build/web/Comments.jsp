<%-- 
    Document   : Comments
    Created on : May 11, 2017, 3:13:18 PM
    
--%>
<%@page import="lazybones.beans.CommentBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="lazybones.services.UserMaintenanceServices"%>
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
                        <li><a href="AdminPanel.jsp">Dashboard</a></li>
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
         <label style="background-color: red">There Was An Error Posting Your Reply....try Again</label>
         <%
                }
            }
        %>
        <%
            ArrayList<CommentBean> al=UserMaintenanceServices.getAllComments();
            for(int i=0;i<al.size();i++)
            {
                CommentBean objbean=al.get(i);
        %>
        <div style="background-color:#f9b332 ; color: black;"  width="50px">
            <b><p><%= objbean.getEmail()%></p></b>
            <label width="50px"><p><%= objbean.getComment()%></p></label>
            <div class="date-time"><%= objbean.getComm_date_time()%></div>
        </div>
        <%
            if(objbean.getReply()==null)
            {
        %>
                
  <div class="dropdown">
                <span style="color: orange; padding-left: 200px">Reply</span>
  <div class="dropdown-content">
    <form>
        <input type="text" id="textreply"><input type="hidden" id="commentid" value="<%= objbean.getCommentid()%>">
        <input type="button" onclick="saveReply()" value="Send" style="background-color: #f9b332;color: black;">
        </form>
  </div>
  </div><br>
        <% 
            }
            else
            {
        %>
        <div style="background-color:#555; color: white;" width="50px">
            <b><p>Admin Reply</p></b>
            <label width="50px"><p><%= objbean.getReply()%></p></label>
            <div class="date-time"><%= objbean.getRep_date_time()%></div>
        </div><br><br>
        <%
            }

            }
        %>
        </div>
    </body>
    <script>
        function saveReply()
        {
            var reply=document.getElementById("textreply").value.trim();
            if(reply=="")
            {
                window.alert("Write A Reply");
            }
            else
            {
                var commentid=document.getElementById("commentid").value.trim();
                window.location.href="savereply?reply="+reply+"&commentid="+commentid;
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
