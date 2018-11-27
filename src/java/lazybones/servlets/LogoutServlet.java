/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lazybones.services.ManageProfileServices;

/**
 *
 * @author DELL
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(false);
        if(s!=null)
        {
            int activityid= (Integer)s.getAttribute("activityid");
            if(ManageProfileServices.updateLogoutTime(activityid))
            {
                s.invalidate();
                resp.sendRedirect("Guest.jsp");  //Home Page
            }
        }
    }

}
