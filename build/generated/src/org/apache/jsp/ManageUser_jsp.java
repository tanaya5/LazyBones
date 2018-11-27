package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lazybones.services.UserMaintenanceServices;
import lazybones.beans.UserBean;
import java.util.ArrayList;

public final class ManageUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <table border=\"3\" cellpadding=\"5\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Mobile Number</th>\n");
      out.write("                <th>Gender</th>\n");
      out.write("                <th>User Type</th>\n");
      out.write("                <th>User Status</th>\n");
      out.write("                <th>Signup Using</th>\n");
      out.write("                <th>    </th>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");
 int pg = 0;
                if (request.getParameter("pg") != null) {
                    pg = Integer.parseInt(request.getParameter("pg"));
                } else {
                    pg = 1;
                }
                ArrayList<UserBean> al = UserMaintenanceServices.getAllUsers(pg);
                for (int i = 0; i < al.size(); i++) {
                    UserBean objbean = al.get(i);
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( objbean.getEmail());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( objbean.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( objbean.getContact());
      out.write("</td>\n");
      out.write("                ");

                    if (objbean.isGender()) {
                
      out.write("\n");
      out.write("                <td>Female</td>\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <td>Male</td>\n");
      out.write("                ");

                    }
                if(objbean.getType().equalsIgnoreCase("Administrator"))
                {
                
      out.write("\n");
      out.write("                <td>");
      out.print( objbean.getType());
      out.write("   <a href=\"ChangeUserType?userid=");
      out.print(objbean.getUserid());
      out.write("&pg=");
      out.print(pg);
      out.write("\"><img src=\"admin.png\" width=\"20px\" height=\"20px\"></a></td>\n");
      out.write("                ");

                 }
                else
                {
                
      out.write("\n");
      out.write("                <td>");
      out.print( objbean.getType());
      out.write("   <a href=\"ChangeUserType?userid=");
      out.print(objbean.getUserid());
      out.write("&pg=");
      out.print(pg);
      out.write("\"><img src=\"user.png\" width=\"20px\" height=\"20px\"></a></td>\n");
      out.write("                ");

                }
                    if (objbean.isStatus()) {
                
      out.write("\n");
      out.write("                <td>Active  <a href=\"ActiveInactive?userid=");
      out.print(objbean.getUserid());
      out.write("&pg=");
      out.print(pg);
      out.write("\"><img src=\"c.jpg\" width=\"20px\" height=\"20px\"></a></td>\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <td>Inactive <a href=\"ActiveInactive?userid=");
      out.print(objbean.getUserid());
      out.write("&pg=");
      out.print(pg);
      out.write("\"><img src=\"T.jpg\" width=\"20px\" height=\"20px\"></a></td>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                <td>");
      out.print( objbean.getSignup());
      out.write("</td>\n");
      out.write("                <td>    </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table><br>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("        \n");
      out.write("        ");

             int count=UserMaintenanceServices.numberOfRegisteredUsers();
             int j=0;
             if(count%10==0)
             {
                 j=count/10;
             }
             else
             {
                 j=(count/10)+1;
             }
             for(int i=1;i<=j;i++)
             {
                 out.println("&nbsp;&nbsp;<a href='ManageUser.jsp?pg="+i+"'>"+i+"</a>");
             }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("        <button onclick=\"location.href='AdminPanel.jsp'\">Back</button>\n");
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
