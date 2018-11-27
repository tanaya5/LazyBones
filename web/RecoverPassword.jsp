<%-- 
    Document   : Recover password Page
    Created on : 24 Apr, 2017, 5:39:09 PM
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recover Password Page</title>
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
        <div >
            <!--<form>-->
           
            <center>
                 <div >
                <fieldset id="from" style="width: 500px;background-color:#111; color: #f9b332; ">
                    <label  id="lbmsg" style="background-color: red"></label>
                    <h2><b>Forgot Password?</b></h2><br>
                    <h5> SEND OTP TO:</h5><br>
                    <button onclick="emailOTP()" style="background-color: #f9b332;color: black">Email</button>
                    <label> OR </label>
                    <button onclick="smsOTP()" style="background-color: #f9b332;color: black">Mobile Number</button><br><br><br>
                    <input type="number" id="textotp" name="textotp" placeholder="Enter OTP Here"><br>
                    <input type="hidden" id="hiddenotp" name="hiddenotp">
                    <%
                        String email = request.getParameter("email");
                        session.setAttribute("email", email);
                    %>
                    <br><br>
                    <label> Haven't received OTP?</label><br>
                    <label> Click again to resend OTP.</label><br><br><br><br>
                    <button onclick="verifyOTP()" style="background-color: #f9b332;color: black">SUBMIT</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:cancelPass()" >CANCEL</a>
                </fieldset>
                    </div>
           <!-- </form>-->
           </center>
        </div>

                    <script type="text/javascript">
            function emailOTP()
            {
                document.getElementById("lbmsg").innerHTML ="";
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200)
                    {
                        if (this.responseText == "failed")
                        {
                            document.getElementById("lbmsg").innerHTML = "There Was An Error Sending The OTP...Try Again!!!";
                        }
                        else if (this.responseText == "Not Registered")
                        {
                            document.getElementById("lbmsg").innerHTML = "Your Email Is Not Registered With Us.";
                        } 
                        else
                        {
                            document.getElementById("lbmsg").innerHTML = "OTP Has Been Sent To Your Registered Email.";
                            document.getElementById("hiddenotp").value = this.responseText;
                            document.getElementById("textotp").focus();
                        }
                    }
                };
                var url = "emailotp";
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            
            function verifyOTP()
            {
               var otp=document.getElementById("textotp").value.trim();
               if(otp=="")
               {
                   document.getElementById("lbmsg").innerHTML="Please Enter The OTP";
                   document.getElementById("textotp").focus();
               }
               else
               {
                   var hidden=document.getElementById("hiddenotp").value.trim();
                   if(otp==hidden)
                   {
                       window.location.href="ResetPassword.jsp";
                   }
                   else
                   {
                       document.getElementById("lbmsg").innerHTML="The Entered OTP Is Incorrect";
                   }
               }
            }
            
            function cancelPass()
            {
                if(confirm("Password Recovery Process Is Not Complete Yet.\nDoing This Will Not Reset Your Password. ")==true)
                {
                    window.location.href="Login.jsp";
                }
            }
            
            function smsOTP()
            {
                document.getElementById("lbmsg").innerHTML ="";
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200)
                    {
                        if (this.responseText == "not provided")
                        {
                            document.getElementById("lbmsg").innerHTML = "You Have Not Provided Us With Your Mobile Number.\nTry With Email";
                        }
                        else if (this.responseText == "not registered")
                        {
                            document.getElementById("lbmsg").innerHTML = "Your Email Is Not Registered With Us.";
                        } 
                        else
                        {
                            document.getElementById("lbmsg").innerHTML = "OTP Has Been Sent To Your Mobile Number. ";
                            document.getElementById("hiddenotp").value = this.responseText;
                            document.getElementById("textotp").focus();
                        }
                    }
                };
                var url = "smsotp";
                xhttp.open("GET", url, true);
                xhttp.send();
            }
            
            
        </script>
    </body>
</html>
