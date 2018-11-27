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
import lazybones.beans.DocumentBean;
import lazybones.services.ManageProfileServices;
import lazybones.services.PSO;

/**
 *
 * @author DELL
 */
public class PSOGuestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
                String path = req.getParameter("path");
                int size = Integer.parseInt(req.getParameter("size"));
                System.out.println(path);
                PSO obj = new PSO();
                obj.pso(path, size);
                String summary=path.replace(".txt","_summary.txt");
                resp.sendRedirect("ViewSummary.jsp?path="+summary);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
