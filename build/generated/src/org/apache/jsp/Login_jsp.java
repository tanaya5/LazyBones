package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"217480766842-v9hseakrkh9ncio2f374jhqdfvc1i9b8.apps.googleusercontent.com\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css?family=Poppins:300\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"font-awesome.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css?family=Poppins:300\" rel=\"stylesheet\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"bootstrap.min.css\">\n");
      out.write("            <link rel=\"stylesheet\" href=\"font-awesome.css\">\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            #form\n");
      out.write("            {\n");
      out.write("                width: 500px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #292626\"> \n");
      out.write("        <section class=\"logo\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h1> LOGO </h1>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        <div  >\n");
      out.write("             <span style=\"font-size:30px;cursor:pointer; float:right; color:white; margin-right:20px;\" onclick=\"openNav()\">&#9776;</span>\n");
      out.write("    \n");
      out.write("            <div id=\"mySidenav\" class=\"rightsidenav\">\n");
      out.write("                <a href=\"javascript:void(0)\" class=\"closebtn\" onclick=\"closeNav()\">&times;</a>\n");
      out.write("                    <ul class=\"full-nav\">\n");
      out.write("                        <li><a href=\"Guest.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"SignUp.jsp\">SignUp</a></li>\n");
      out.write("                        <li><a href=\"#\">About Us</a></li>\n");
      out.write("                        <li><a href=\"#\">Contact Us</a></li>\n");
      out.write("                    </ul>\n");
      out.write("            </div>\n");
      out.write("         \n");
      out.write("\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        \n");
      out.write("            <center>\n");
      out.write("            <form action=\"login\" method=\"post\" id=\"form\">\n");
      out.write("                <div class=\"form\" style=\"background-color:#111; color: #f9b332\">\n");
      out.write("                <fieldset >\n");
      out.write("                    ");
if (request.getParameter("msg") != null) {
                            if (request.getParameter("msg").equals("Inactive User")) {
                                out.println("<label style='background-color:red'> !  The User Is Blocked By The Admin</label>");
                            } else if (request.getParameter("msg").equals("Login Unsuccessful")) {
                                out.println("<label style='background-color:red'> !  The Email Or Password You Entered Is Incorrect</label>");
                            } else if (request.getParameter("msg").equals("Reset Password Successful")) {
                                out.println("<label style='background-color:red'> !  Your Password Has Been Reset Successfully</label>");
                            } else if (request.getParameter("msg").equals("Reset Password Failed")) {
                                out.println("<label style='background-color:red'> !  There Was An Error While Resetting The Password...Try Again</label>");
                            }
                             else if (request.getParameter("msg").equals("Error")) {
                                out.println("<label style='background-color:red'> !  There Was An Error While Logging In....Try Again</label>");
                            }
                        }
                    else
                    {
                        if(session!=null)
                        {
                            session.invalidate();
                        }
                    }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <div><b><h2>Login to LAZYBONES</h2><b></div><br>\n");
      out.write("                    <div><h5>USING</h5></div><br>\n");
      out.write("                    <div><div class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div> <br>\n");
      out.write("                        <label> OR </label><br>\n");
      out.write("                        <fb:login-button scope=\"public_profile,email\" onlogin=\"checkLoginState();\">\n");
      out.write("                        </fb:login-button></div>\n");
      out.write("                    <div> <h5>-OR USING EMAIL-</h5> </div>\n");
      out.write("                    <div> <input type=\"email\" name=\"textemail\" id=\"textemail\" placeholder=\"Your Email Address\" required><br> <br>\n");
      out.write("                        <input type=\"password\" name=\"textpassword\" id=\"textpassword\" placeholder=\"Enter Password\" required><br> <br><br>\n");
      out.write("                        <input type=\"submit\" value=\"LOGIN\" style=\"background-color: #f9b332;color: black;width: 180px\"><br><br><br></div>\n");
      out.write("                    <div> <a href=\"javascript:recoverPassword()\" >Recover Password</a>\n");
      out.write("                        <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; New to LAZYBONES?</label>\n");
      out.write("                        <a href=\"SignUp.jsp\" >Create Account</a></div><br><br><br>\n");
      out.write("                </fieldset>\n");
      out.write("                    </div>\n");
      out.write("            </form>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function recoverPassword()\n");
      out.write("            {\n");
      out.write("                var email = document.getElementById(\"textemail\").value.trim();\n");
      out.write("                if (email === \"\")\n");
      out.write("                {\n");
      out.write("                    window.alert(\"Enter Your Email\");\n");
      out.write("                    document.getElementById(\"textemail\").focus();\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    var url = \"RecoverPassword.jsp?email=\" + email;\n");
      out.write("                    window.location.href = url;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function statusChangeCallback(response) {\n");
      out.write("                console.log('statusChangeCallback');\n");
      out.write("                console.log(response);\n");
      out.write("\n");
      out.write("                if (response.status === 'connected') {\n");
      out.write("\n");
      out.write("                    testAPI();\n");
      out.write("                } else {\n");
      out.write("\n");
      out.write("                    document.getElementById('status').innerHTML = 'Please log ' +\n");
      out.write("                            'into this app.';\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            function checkLoginState() {\n");
      out.write("                FB.getLoginStatus(function (response) {\n");
      out.write("                    statusChangeCallback(response);\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            window.fbAsyncInit = function () {\n");
      out.write("                FB.init({\n");
      out.write("                    appId: '1456542897700174',\n");
      out.write("                    cookie: true,\n");
      out.write("\n");
      out.write("                    xfbml: true,\n");
      out.write("                    version: 'v2.8'\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                FB.getLoginStatus(function (response) {\n");
      out.write("                    statusChangeCallback(response);\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            };\n");
      out.write("\n");
      out.write("\n");
      out.write("            (function (d, s, id) {\n");
      out.write("                var js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("                if (d.getElementById(id))\n");
      out.write("                    return;\n");
      out.write("                js = d.createElement(s);\n");
      out.write("                js.id = id;\n");
      out.write("                js.src = \"//connect.facebook.net/en_US/sdk.js\";\n");
      out.write("                fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("            }(document, 'script', 'facebook-jssdk'));\n");
      out.write("\n");
      out.write("\n");
      out.write("            function testAPI() {\n");
      out.write("                console.log('Welcome!  Fetching your information.... ');\n");
      out.write("                FB.api('/me', {fields: 'name, email'}, function (response) {\n");
      out.write("                    /*console.log('Successful login for: ' + response.name);\n");
      out.write("                     document.getElementById('status').innerHTML =\n");
      out.write("                     'Thanks for logging in, ' + response.name;\n");
      out.write("                     document.getElementById('eid').innerHTML =\n");
      out.write("                     'Your ID is, '+response.id;\n");
      out.write("                     document.getElementById('em').innerHTML =\n");
      out.write("                     'Your email is, ' +response.email;*/\n");
      out.write("\n");
      out.write("                    var xhttp = new XMLHttpRequest();\n");
      out.write("                    xhttp.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState === 4 && this.status === 200) {\n");
      out.write("                            if (this.responseText === \"User\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"UserPanel.jsp\";\n");
      out.write("                            } else if(this.responseText === \"Administrator\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"AdminPanel.jsp\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Error\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Error\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Inactive User\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Inactive User\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Login Unsuccessful\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Login Unsuccessful\";\n");
      out.write("                            }\n");
      out.write("                            else\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"VerificationPage.jsp?email=\"+this.responseText;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    var url = \"facebooklogin\";\n");
      out.write("                    var params = \"email=\" + response.email + \"&id=\" + response.id;\n");
      out.write("                    xhttp.open(\"POST\", url, true);\n");
      out.write("                    xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                    xhttp.send(params);\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function onSignIn(googleUser) {\n");
      out.write("                var profile = googleUser.getBasicProfile();\n");
      out.write("                /*document.write('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.\n");
      out.write("                document.write('Name: ' + profile.getName());\n");
      out.write("                document.write('Image URL: ' + profile.getImageUrl());\n");
      out.write("                document.write('Email: ' + profile.getEmail()+'<br>');*/ // This is null if the 'email' scope is not present.\n");
      out.write("               \n");
      out.write("               var xhttp = new XMLHttpRequest();\n");
      out.write("                    xhttp.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState === 4 && this.status === 200) {\n");
      out.write("                            if (this.responseText === \"User\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"UserPanel.jsp\";\n");
      out.write("                            } else if(this.responseText === \"Administrator\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"AdminPanel.jsp\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Error\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Error\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Inactive User\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Inactive User\";\n");
      out.write("                            }\n");
      out.write("                            else if(this.responseText === \"Login Unsuccessful\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"Login.jsp?msg=Login Unsuccessful\";\n");
      out.write("                            }\n");
      out.write("                            else\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"VerificationPage.jsp?email=\"+this.responseText;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    var url = \"googlelogin\";\n");
      out.write("                    var params = \"email=\" + profile.getEmail() + \"&id=\" + profile.getId();\n");
      out.write("                    xhttp.open(\"POST\", url, true);\n");
      out.write("                    xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                    xhttp.send(params);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("            function signOut() {\n");
      out.write("                var auth2 = gapi.auth2.getAuthInstance();\n");
      out.write("                auth2.signOut().then(function () {\n");
      out.write("                    document.write('User signed out.');\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("         <script>\n");
      out.write("        function openNav() {\n");
      out.write("            document.getElementById(\"mySidenav\").style.width = \"100%\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function closeNav() {\n");
      out.write("            document.getElementById(\"mySidenav\").style.width = \"0\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
