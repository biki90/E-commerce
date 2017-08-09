/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bikash
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>");
                out.write("<html>");
                out.write("<head>");
                out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.write("<title> Bikash Finance - Home</title>");
                out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\">");
                out.write("");
                out.write("</head>");
                out.write("");
                out.write("<body>");
                out.write("<div id=\"wrapper\">");
                out.write("<div id=\"header\">");
                out.write("<h1>Bikash Finance</h1>");
                out.write("<p id=\"login\">You are not logged in.</p>");
                out.write("<ul id=\"nav\">");
                out.write("<li><a href=\"home\">HOME</a></li>");                
                out.write("<li><a href=\"login\">LOGIN</a></li>");
                out.write("<li><a href=\"registration\">REGISTER</a></li>");
                out.write("<div id=\"image\">");
                out.write("<img src=\"css/Stock_1.jpg\" width=\"970\" height=\"330\" />");
                out.write("</div>");
                out.write("</div>");
                out.write("<div id=\"bodypart1\">");
                out.write("<br>");
                out.write("<h2 id=\"welcome\">Welcome to Bikash Finance</h2>");
                out.write("<br>"); 
                out.write("</p>At BikashFinance, you have instant access to free, stock quotes of your favorite companies, mutual funds, indexes, bonds, ETFs, futures and other financial assets. <p/>  ");
                out.write("<br>");
                out.write("<p>Register free... <p>");
                out.write("</div>");
                out.write("</div>");
                out.write("</body>");
                out.write("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
