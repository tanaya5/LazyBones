/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lazybones.beans.DocumentBean;
import lazybones.services.ManageProfileServices;

/**
 *
 * @author DELL
 */
public class CreateFileGuestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    FileWriter fw=null;
        try {
                String str = (String)req.getParameter("str");
                System.out.println(str);
                String a[]=str.split("\\s",2);
                String fname ="C:\\Users\\DELL\\Documents\\NetBeansProjects\\Lazybones\\build\\web\\UploadFiles\\"+a[0]+"_guest.txt";
                fw=new FileWriter(fname);
                fw.write(str);
                fw.flush();
                fw.close();
                resp.getWriter().write(fname);   
            }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
