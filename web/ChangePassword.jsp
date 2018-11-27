<%-- 
    Document   : ChangePassword
    Created on : May 9, 2017, 11:35:42 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Change Password</title>
        <style>
            #form
            {
                width: 500px;
            }
        </style>
        <title> Change Password</title>
         <link href="https://fonts.googleapis.com/css?family=Poppins:300" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome.css">

    <link rel="stylesheet" href="bootstrap.min.css">

    <link rel="stylesheet" href="style.css">
        </head>

    <body style="background-color: #292626">
         <section class="logo">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1> LOGO </h1>                          
                        </div>
                    </div>
                </div>
            </section>
        
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
        <div >
         
        <center>
        <form action="changepassword" onsubmit="return validateForm()" method="post" id="form">
               <div  style="background-color:#111; color: #f9b332;" >
            <fieldset >

                <%
                    if (request.getParameter("msg") != null) {
                        if (request.getParameter("msg").equals("Missmatch")) {
                %>
                <label style="background-color: red">You Entered Invalid Old Password</label>
                <%
                } else {
                %>
                <label style="background-color: red">There Was An Error While Changing The Password...Try Again!!</label>
                <%
                        }
                    }

                %>
               
               <br><br> <div><b><h2>Change Password</h2></b></div><br><br>
                <div >
                <input style="width: 240px;" type="password" name="textoldpassword" id="textoldpassword" placeholder="Old Password" required><br> <br>
                <input style="width: 240px;" type="password" name="textnewpassword" id="textnewpassword" placeholder="New Password" required><br><br>
                <input style="width: 240px;" type="password" name="textconfirmpassword" id="textconfirmpassword" placeholder="Confirm Password" required><br><br>
                <input type="submit" value="Change Password" style="background-color: #f9b332;color: black; width: 240px"><br><br><br><br>
                </div>
                
            </fieldset>
                </div>
                </center>
        </form>
        </div>
        <script>
            function validateForm()
            {
                var newpwd = document.getElementById("textnewpassword").value.trim();
                var conpwd = document.getElementById("textconfirmpassword").value.trim();
                if (newpwd != conpwd)
                {
                    window.alert("Confirm Password Correctly!!!");
                    document.getElementById("textconfirmpassword").focus();
                    return false;
                }
                return true;
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
