/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lazybones.services.UserMaintenanceServices;

/**
 *
 * @author DELL
 */
public class ChangeUserTypeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if(s!=null)
        {
            int i=Integer.parseInt(req.getParameter("userid"));
            int pg=Integer.parseInt(req.getParameter("pg"));
            if(UserMaintenanceServices.changeUserType(i))
            {
                resp.sendRedirect("ManageUser.jsp?pg="+pg);
            }
            else
            {
                resp.sendRedirect("ManageUser.jsp?pg="+pg);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
