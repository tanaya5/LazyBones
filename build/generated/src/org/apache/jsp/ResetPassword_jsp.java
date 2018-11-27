package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ResetPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Reset Password Page</title>\n");
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
      out.write("        <div  >\n");
      out.write("            <center>\n");
      out.write("            <form action=\"resetpassword\" onsubmit=\"return validateForm()\" method=\"post\" id=\"form\">\n");
      out.write("                <div style=\"background-color:#111; color: #f9b332;\">\n");
      out.write("                <fieldset>\n");
      out.write("                   <br> <br><h2><b>Reset Password</b></h2><br>\n");
      out.write("                    <input type=\"password\" id=\"textnewpassword\" name=\"textnewpassword\" placeholder=\"New Password\" required><br><br>\n");
      out.write("                    <input type=\"password\" id=\"textconfirmpassword\" name=\"textconfirmpassword\" placeholder=\"Confirm Password\" required>\n");
      out.write("                    <br><br><br>\n");
      out.write("                    <button style=\"background-color: #f9b332;color: black; width: 180px\"> RESET PASSWORD </button><br><br><br><br>\n");
      out.write("                </fieldset>\n");
      out.write("                  </div>\n");
      out.write("            </form>\n");
      out.write("                </center>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function validateForm()\n");
      out.write("            {\n");
      out.write("                var newpwd = document.getElementById(\"textnewpassword\").value.trim();\n");
      out.write("                var conpwd = document.getElementById(\"textconfirmpassword\").value.trim();\n");
      out.write("                if (newpwd != conpwd)\n");
      out.write("                {\n");
      out.write("                    window.alert(\"Confirm Password Correctly!!!\");\n");
      out.write("                    document.getElementById(\"textconfirmpassword\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                return true;\n");
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
