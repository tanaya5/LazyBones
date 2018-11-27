package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lazybones.services.ManageProfileServices;
import lazybones.beans.UserBean;

public final class ViewProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>    \n");
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
      out.write("            <center>\n");
      out.write("        \n");
      out.write("        ");

            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                UserBean objbean=ManageProfileServices.viewProfile(userid);
        
      out.write("\n");
      out.write("        <fieldset style=\"background-color:#111; color: #f9b332;\" id=\"form\" >\n");
      out.write("            ");

                    if(request.getParameter("msg")!=null)
                    {
                       if(request.getParameter("msg").equals("Edit Successful"))
                       {
                
      out.write("\n");
      out.write("                <label style=\"background-color: red\">Your Profile Was Edited Successfully</label><br><br>\n");
      out.write("                ");

                       }
                    }
                
      out.write("\n");
      out.write("           <br><br> <label><b>Email:</b></label>\n");
      out.write("            <label> ");
      out.print( objbean.getEmail());
      out.write("</label><br><br><br>\n");
      out.write("            <label><b>Name:</b></label>\n");
      out.write("            <label>");
      out.print( objbean.getName());
      out.write("</label><br><br><br>\n");
      out.write("            <label><b>Mobile Number:</b></label>\n");
      out.write("            <label>");
      out.print( objbean.getContact());
      out.write("</label><br><br><br>\n");
      out.write("            <label><b>Gender:</b></label>\n");
      out.write("            ");

                if(objbean.isGender())
                {
            
      out.write("\n");
      out.write("            <label>Female</label><br><br>\n");
      out.write("            ");

                }
                else
                {
            
      out.write("\n");
      out.write("            <label>Male</label><br><br>\n");
      out.write("            ");

                }
                }
            
      out.write("\n");
      out.write("            <br><button onclick=\"location.href='UserPanel.jsp'\" style=\"background-color: #f9b332;color: black\">Back</button>\n");
      out.write("       <br><br><br> </fieldset>\n");
      out.write("            </center>\n");
      out.write("            </div>\n");
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
