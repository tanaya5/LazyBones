<%-- 
    Document   : Reset Password Page
    Created on : 24 Apr, 2017, 5:43:31 PM
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reset Password Page</title>
         <style>
            
            #form
            {
                width: 500px;
            }
        </style>
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
        <div  >
            <center>
            <form action="resetpassword" onsubmit="return validateForm()" method="post" id="form">
                <div style="background-color:#111; color: #f9b332;">
                <fieldset>
                   <br> <br><h2><b>Reset Password</b></h2><br>
                    <input type="password" id="textnewpassword" name="textnewpassword" placeholder="New Password" required><br><br>
                    <input type="password" id="textconfirmpassword" name="textconfirmpassword" placeholder="Confirm Password" required>
                    <br><br><br>
                    <button style="background-color: #f9b332;color: black; width: 180px"> RESET PASSWORD </button><br><br><br><br>
                </fieldset>
                  </div>
            </form>
                </center>
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
    </body>
</html>
