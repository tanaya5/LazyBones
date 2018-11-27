/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazybones.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import javax.servlet.http.HttpSession;
import lazybones.beans.DocumentBean;
import lazybones.services.ManageProfileServices;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB 

public class UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "UploadFiles";

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        if (s != null) {
            int userid = (int) s.getAttribute("userid");
            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String savePath = appPath + File.separator + SAVE_DIR;

            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            String name = "";
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                // refines the fileName in case it is an absolute path
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);
                name = savePath + File.separator + fileName;
            }
            if (name.endsWith(".docx")) {
                try {

                    String fname = "";
                    fname = name.replace(".docx", ".txt");
                    FileInputStream fs = new FileInputStream(name);
                    //create document object to wrap the file inputstream object
                    XWPFDocument docx = new XWPFDocument(fs);
                    //create text extractor object to extract text from the document
                    XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
                    //create file writer object to write text to the output file
                    FileWriter fw = new FileWriter(fname);
                    //write text to the output file  
                    fw.write(extractor.getText());
                    //clear data from memory
                    fw.flush();
                    //close inputstream and file writer
                    fs.close();
                    fw.close();

                    DocumentBean objbean = new DocumentBean();
                    objbean.setUserid(userid);
                    objbean.setName(fname);
                    objbean.setType("Original");
                    if (ManageProfileServices.saveDocument(objbean)) {
                        request.setAttribute("message", "Upload has been done successfully!");
                        response.sendRedirect("Summarize.jsp?msg=" + fname);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                DocumentBean objbean = new DocumentBean();
                objbean.setUserid(userid);
                objbean.setName(name);
                objbean.setType("Original");
                if (ManageProfileServices.saveDocument(objbean)) {
                    request.setAttribute("message", "Upload has been done successfully!");
                    response.sendRedirect("Summarize.jsp?msg=" + name);
                    //getServletContext().getRequestDispatcher("/Summarize.jsp?msg="+name).forward(
                    // request, response); 
                }

            }
        }

    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}
