package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lazybones.beans.UserBean;
import lazybones.services.ManageProfileServices;

public final class EditProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Edit Profile</title>\n");
      out.write("         <style>\n");
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
      out.write("      <div  >\n");
      out.write("        <center>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.viewProfile(userid);
        
      out.write("\n");
      out.write("        <form action=\"edit.jsp\" method=\"\" id=\"form\">\n");
      out.write("            <div style=\"background-color:#111; color: #f9b332\">\n");
      out.write("            <fieldset>\n");
      out.write("                ");

                    if(request.getParameter("msg")!=null)
                    {
                       if(request.getParameter("msg").equals("Edit Failed"))
                       {
                
      out.write("\n");
      out.write("                <label style=\"background-color: red\">There Was A Problem In Editing Your Profile...Try Again</label><br><br>\n");
      out.write("                ");

                       }
                    }
                
      out.write("\n");
      out.write("            <br><br><label><b>Email:</b></label>\n");
      out.write("            <input type=\"text\" readonly name=\"email\" value=\"");
      out.print( objbean.getEmail() );
      out.write("\"><br><br><br>\n");
      out.write("            <label><b>Name:</b></label>\n");
      out.write("            <input type=\"text\" name=\"name\" value=\"");
      out.print( objbean.getName());
      out.write("\" required></label><br><br><br>\n");
      out.write("            <label><b>Mobile Number:</b></label>\n");
      out.write("            <input type=\"text\" name=\"contact\" value=\"");
      out.print( objbean.getContact());
      out.write("\"></label><br><br><br>\n");
      out.write("            <label><b>Gender:</b></label>\n");
      out.write("            ");

                if(objbean.isGender())
                {
            
      out.write("\n");
      out.write("            <input type=\"radio\" name=\"rbgender\" value=\"Female\" checked>Female\n");
      out.write("            <input type=\"radio\" name=\"rbgender\" value=\"Male\">Male<br><br>\n");
      out.write("            ");

                }
                else
                {
            
      out.write("\n");
      out.write("            <input type=\"radio\" name=\"rbgender\" value=\"Female\">Female\n");
      out.write("            <input type=\"radio\" name=\"rbgender\" value=\"Male\" checked>Male<br><br>\n");
      out.write("            ");

                }
                }
            
      out.write("\n");
      out.write("            <br><br> <input type=\"submit\" value=\"Save\" style=\"background-color: #f9b332;color: black; width: 200px;\"><br><br><br>\n");
      out.write("        </fieldset>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
      out.write("      </div>\n");
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
