package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Sign Up Page</title>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"217480766842-v9hseakrkh9ncio2f374jhqdfvc1i9b8.apps.googleusercontent.com\">\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script> \n");
      out.write("        <style>\n");
      out.write("           \n");
      out.write("            #form\n");
      out.write("            {\n");
      out.write("                width: 500px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #292626\">\n");
      out.write("         <section class=\"logo\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <h1> LOGO </h1>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        <div  >\n");
      out.write("            <center>\n");
      out.write("                <form action=\"signup\" method=\"post\" id=\"form\">\n");
      out.write("                    <div style=\"background-color:#111; color: #f9b332;\">\n");
      out.write("                        <fieldset>\n");
      out.write("                            <label style=\"background-color: red\" id=\"lbpopup\"></label>\n");
      out.write("                            ");
if (request.getParameter("msg") != null) {
                                    out.println("<label style='background-color:red'>There Was An Error Signing Up...Try Again</label>");
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <div><h2>Signup with LAZYBONES</h2></div>\n");
      out.write("                            <div> <h5>USING</h5> </div>\n");
      out.write("                            <div> <div class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div>\n");
      out.write("                                <label> OR </label><br>\n");
      out.write("                                <fb:login-button scope=\"public_profile,email\" onlogin=\"checkLoginState();\">\n");
      out.write("                                </fb:login-button></div>\n");
      out.write("                            <div> <h5>-OR USING EMAIL-</h5> </div>\n");
      out.write("                            <div> &nbsp;<input type=\"email\" name=\"textemail\" id=\"textemail\" placeholder=\"Your Email Address\" required onblur=\"checkEmail()\" >\n");
      out.write("                                <label id=\"lbmsg\" style=\"color:red\"></label>\n");
      out.write("                                <br> \n");
      out.write("                                <input type=\"text\" name=\"textname\" id=\"textname\" placeholder=\"Name\" required><br>\n");
      out.write("                                <input type=\"password\" name=\"textpassword\" id=\"textpassword\" placeholder=\"Choose Password\" required><br>\n");
      out.write("                                <input type=\"text\" name=\"textmobile\" id=\"textmobile\" placeholder=\"Mobile Number (with country code)\" required><br> \n");
      out.write("\n");
      out.write("                                <label>I'm a</label>\n");
      out.write("                                <input type=\"radio\" name=\"rbgender\" value=\"Female\" checked>Female\n");
      out.write("                                <input type=\"radio\" name=\"rbgender\" value=\"Male\">Male<br><br>\n");
      out.write("                                <input type=\"submit\" value=\"REGISTER\" style=\"background-color: #f9b332;color: black; width: 180px\"><br><br><br></div>\n");
      out.write("                            <div> \n");
      out.write("                                <label> Already have an account?</label>\n");
      out.write("                                <a href=\"Login.jsp\">Login</a></div>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function checkEmail()\n");
      out.write("            {\n");
      out.write("                var email = document.getElementById(\"textemail\").value;\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        if (this.responseText == \"false\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"Email is already registered!!\";\n");
      out.write("                            document.getElementById(\"textemail\").focus();\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"\";\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var url = \"checkemail?email=\" + email;\n");
      out.write("                xhttp.open(\"GET\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
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
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            if (this.responseText == \"false\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"lbpopup\").innerHTML = \"There Was An Error Signing Up....Try Again\";\n");
      out.write("                            } else\n");
      out.write("                            {\n");
      out.write("                                window.location.href = \"VerificationPage.jsp?email=\"+response.email;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    var url = \"facebooksignup\";\n");
      out.write("                    var params = \"email=\" + response.email + \"&id=\" + response.id + \"&name=\" + response.name;\n");
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
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            if (this.responseText == \"false\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"lbpopup\").innerHTML = \"There Was An Error Signing Up....Try Again\";\n");
      out.write("                            } else if(this.responseText == \"true\")\n");
      out.write("                            {\n");
      out.write("                                window.location.href=\"VerificationPage.jsp?email=\"+profile.getEmail();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    var url = \"googlesignup\";\n");
      out.write("                    var params = \"email=\" + profile.getEmail() + \"&id=\" + profile.getId() + \"&name=\" + profile.getName();\n");
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
