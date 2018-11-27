package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RecoverPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Recover Password Page</title>\n");
      out.write("         <style>\n");
      out.write("            \n");
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
      out.write("        <div >\n");
      out.write("            <!--<form>-->\n");
      out.write("           \n");
      out.write("            <center>\n");
      out.write("                 <div >\n");
      out.write("                <fieldset id=\"from\" style=\"width: 500px;background-color:#111; color: #f9b332; \">\n");
      out.write("                    <label  id=\"lbmsg\" style=\"background-color: red\"></label>\n");
      out.write("                    <h2>Forgot Password?</h2>\n");
      out.write("                    <h5> SEND OTP TO:</h5>\n");
      out.write("                    <button onclick=\"emailOTP()\" style=\"background-color: #f9b332;color: black\">Email</button>\n");
      out.write("                    <label> OR </label>\n");
      out.write("                    <button onclick=\"smsOTP()\" style=\"background-color: #f9b332;color: black\">Mobile Number</button><br><br>\n");
      out.write("                    <input type=\"number\" id=\"textotp\" name=\"textotp\" placeholder=\"Enter OTP Here\">\n");
      out.write("                    <input type=\"hidden\" id=\"hiddenotp\" name=\"hiddenotp\">\n");
      out.write("                    ");

                        String email = request.getParameter("email");
                        session.setAttribute("email", email);
                    
      out.write("\n");
      out.write("                    <br><br>\n");
      out.write("                    <label> Haven't received OTP?</label><br>\n");
      out.write("                    <label> Click again to resend OTP.</label><br><br><br>\n");
      out.write("                    <button onclick=\"verifyOTP()\" style=\"background-color: #f9b332;color: black\">SUBMIT</button>\n");
      out.write("                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                    <a href=\"javascript:cancelPass()\" >CANCEL</a>\n");
      out.write("                </fieldset>\n");
      out.write("                    </div>\n");
      out.write("           <!-- </form>-->\n");
      out.write("           </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("            function emailOTP()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"lbmsg\").innerHTML =\"\";\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200)\n");
      out.write("                    {\n");
      out.write("                        if (this.responseText == \"failed\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"There Was An Error Sending The OTP...Try Again!!!\";\n");
      out.write("                        }\n");
      out.write("                        else if (this.responseText == \"Not Registered\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"Your Email Is Not Registered With Us.\";\n");
      out.write("                        } \n");
      out.write("                        else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"OTP Has Been Sent To Your Registered Email.\";\n");
      out.write("                            document.getElementById(\"hiddenotp\").value = this.responseText;\n");
      out.write("                            document.getElementById(\"textotp\").focus();\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var url = \"emailotp\";\n");
      out.write("                xhttp.open(\"GET\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function verifyOTP()\n");
      out.write("            {\n");
      out.write("               var otp=document.getElementById(\"textotp\").value.trim();\n");
      out.write("               if(otp==\"\")\n");
      out.write("               {\n");
      out.write("                   document.getElementById(\"lbmsg\").innerHTML=\"Please Enter The OTP\";\n");
      out.write("                   document.getElementById(\"textotp\").focus();\n");
      out.write("               }\n");
      out.write("               else\n");
      out.write("               {\n");
      out.write("                   var hidden=document.getElementById(\"hiddenotp\").value.trim();\n");
      out.write("                   if(otp==hidden)\n");
      out.write("                   {\n");
      out.write("                       window.location.href=\"ResetPassword.jsp\";\n");
      out.write("                   }\n");
      out.write("                   else\n");
      out.write("                   {\n");
      out.write("                       document.getElementById(\"lbmsg\").innerHTML=\"The Entered OTP Is Incorrect\";\n");
      out.write("                   }\n");
      out.write("               }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function cancelPass()\n");
      out.write("            {\n");
      out.write("                if(confirm(\"Password Recovery Process Is Not Complete Yet.\\nDoing This Will Not Reset Your Password. \")==true)\n");
      out.write("                {\n");
      out.write("                    window.location.href=\"Login.jsp\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            function smsOTP()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"lbmsg\").innerHTML =\"\";\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200)\n");
      out.write("                    {\n");
      out.write("                        if (this.responseText == \"not provided\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"You Have Not Provided Us With Your Mobile Number.\\nTry With Email\";\n");
      out.write("                        }\n");
      out.write("                        else if (this.responseText == \"not registered\")\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"Your Email Is Not Registered With Us.\";\n");
      out.write("                        } \n");
      out.write("                        else\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"lbmsg\").innerHTML = \"OTP Has Been Sent To Your Mobile Number. \";\n");
      out.write("                            document.getElementById(\"hiddenotp\").value = this.responseText;\n");
      out.write("                            document.getElementById(\"textotp\").focus();\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var url = \"smsotp\";\n");
      out.write("                xhttp.open(\"GET\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
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
