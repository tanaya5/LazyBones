package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Summarize_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            if (request.getParameter("msg") != null) {
        
      out.write("\n");
      out.write("        <label style=\"background-color: red\" id=\"lbmsg\">File Uploaded Successfully</label>\n");
      out.write("        <input type=\"hidden\" id=\"textpath\" name=\"textpath\" value=\"");
      out.print( request.getParameter("msg"));
      out.write("\">\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <label style=\"background-color: red\" id=\"lbmsg1\"></label>\n");
      out.write("        <input type=\"hidden\" id=\"textpath1\" name=\"textpath1\">\n");
      out.write("        <br><textarea rows=\"15\" cols=\"130\" id=\"tatext\" name=\"tatext\"></textarea><br><br>\n");
      out.write("        <label>OR</label><br><br>\n");
      out.write("        <label>Select A File To Upload:</label><br><br>\n");
      out.write("        <form action=\"upload\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("            <input type=\"file\" id=\"textfile\" name=\"textfile\" accept=\".doc, .docx, .txt\" size=\"80\"><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Upload File\">\n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        <input type=\"text\" name=\"textsize\" id=\"textsize\" size=\"70\" placeholder=\"Enter The % Of Content You Want To Summarize\"><br><br>\n");
      out.write("        <input type=\"button\" onclick=\"check()\" value=\"Summarize\" style=\"width:300px\">\n");
      out.write("        <script>\n");
      out.write("            function check()\n");
      out.write("            {\n");
      out.write("                var str = document.getElementById(\"tatext\").value.trim();\n");
      out.write("                var size = document.getElementById(\"textsize\").value;\n");
      out.write("                if (size == \"\")\n");
      out.write("                {\n");
      out.write("                    window.alert(\"Enter The % Of Content You Want To Summarize.\");\n");
      out.write("                    document.getElementById(\"textsize\").focus();\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    if (str == \"\")\n");
      out.write("                    {\n");
      out.write("                        var path = document.getElementById(\"textpath\").value;\n");
      out.write("                        if (path != \"\")\n");
      out.write("                        {\n");
      out.write("                            var url = \"PSO?path=\" + path+\"&size=\"+size;\n");
      out.write("                            window.location.href = url;\n");
      out.write("                        } else if (path = \"\")\n");
      out.write("                        {\n");
      out.write("                            window.alert(\"Either Enter Text Or Upload A File\");\n");
      out.write("                        }\n");
      out.write("                    } else\n");
      out.write("                    {\n");
      out.write("                        var xhttp = new XMLHttpRequest();\n");
      out.write("                        xhttp.onreadystatechange = function () {\n");
      out.write("                            if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                                document.getElementById(\"textpath1\").value = this.responseText;\n");
      out.write("                                document.getElementById(\"lbmsg1\").innerHTML = \"File Uploaded Successfully\";\n");
      out.write("                                var url1 = \"PSO?path=\" + this.responseText+\"&size=\"+size;\n");
      out.write("                                window.location.href = url1;\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        var url = \"createfile\";\n");
      out.write("                        var param = \"str=\" + str;\n");
      out.write("                        xhttp.open(\"POST\", url, true);\n");
      out.write("                        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("                        xhttp.send(param);\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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
