package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lazybones.services.ManageProfileServices;
import lazybones.beans.CommentBean;
import java.util.ArrayList;

public final class UserComment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <style>\n");
      out.write(".dropdown {\n");
      out.write("    position: relative;\n");
      out.write("    display: inline-block;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-content {\n");
      out.write("    display: none;\n");
      out.write("    position: relative;\n");
      out.write("    cursor: pointer;\n");
      out.write("    background-color: #555;\n");
      out.write("    color:#fff;\n");
      out.write("    text-align:center;\n");
      out.write("    min-width: 160px;\n");
      out.write("    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("    padding: 12px 16px;\n");
      out.write("    z-index: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown:hover .dropdown-content {\n");
      out.write("    display: block;\n");
      out.write("}\n");
      out.write(".date-time\n");
      out.write("{\n");
      out.write("    padding-left: 200px;\n");
      out.write("    font-size: 13px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    <body>\n");
      out.write("        ");

            if(request.getParameter("msg")!=null)
            {
                if(request.getParameter("msg").equals("Failed"))
                {
         
      out.write("\n");
      out.write("         <label style=\"background-color: red\">There Was An Error Posting Your Comment....try Again</label>\n");
      out.write("         ");

                }
            }
        
      out.write("\n");
      out.write("        ");
  
            if(session!=null)
            {
                int userid=(int)session.getAttribute("userid");
                ArrayList<CommentBean> al=ManageProfileServices.getUserComments(userid);
            for(int i=0;i<al.size();i++)
            {
                CommentBean objbean=al.get(i);
        
      out.write("\n");
      out.write("        <div style=\"background-color:#f9b332 ; color: black;\" width=\"50px\">\n");
      out.write("            <b><p>");
      out.print( objbean.getEmail());
      out.write("</p></b>\n");
      out.write("            <label width=\"50px\">\n");
      out.write("                <p>");
      out.print( objbean.getComment());
      out.write("</p></label>\n");
      out.write("            <div class=\"date-time\">");
      out.print( objbean.getComm_date_time());
      out.write("</div>\n");
      out.write("        </div>    \n");
      out.write("        ");

            if(objbean.getReply()!=null)
            {
        
      out.write("\n");
      out.write("        <div style=\"background-color:#555; color: white;\" width=\"50px\">\n");
      out.write("            <b><p>Admin Reply</p></b>\n");
      out.write("            <label width=\"50px\">\n");
      out.write("                <p>");
      out.print( objbean.getReply());
      out.write("</p></label>\n");
      out.write("                <div class=\"date-time\">");
      out.print( objbean.getRep_date_time());
      out.write("</div>\n");
      out.write("        </div><br><br>\n");
      out.write("        ");

            }

            }
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("  <span>Comment</span>\n");
      out.write("  <div class=\"dropdown-content\">\n");
      out.write("    <form>\n");
      out.write("        <input type=\"text\" id=\"textcomment\">\n");
      out.write("        <input type=\"button\" onclick=\"saveComment()\" style=background-color:#f9b332 ; color: black;\" value=\"Send\">\n");
      out.write("        </form>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("        <br>\n");
      out.write("      <br>\n");
      out.write("      <br>\n");
      out.write("      <br>\n");
      out.write("      <br>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function saveComment()\n");
      out.write("        {\n");
      out.write("            var comment=document.getElementById(\"textcomment\").value.trim();\n");
      out.write("            if(comment==\"\")\n");
      out.write("            {\n");
      out.write("                window.alert(\"Write A Comment\");\n");
      out.write("            }\n");
      out.write("            else\n");
      out.write("            {\n");
      out.write("                window.location.href=\"savecomment?comment=\"+comment;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
