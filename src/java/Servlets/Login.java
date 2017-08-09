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
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        String message = (String)request.getAttribute("s");
        if(message==null) message = "";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>");
            out.write("<html>");
            out.write("<head>");
            out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\">");
            out.write("<title> Bikash Finance - Login</title>");
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
            out.write("<li><a href=\"registration\">REGISTRATION</a></li>");
            out.write("</ul>");
            out.write("</div>");
            out.write("<div id=\"bodypart\">");
            out.write("<h2 id=\"loginLabel\">Login</h2>"+ message);
            out.write("<form  id=\"Login-Form\" action=\"checkUser\"  method=\"POST\">");
            out.write("<label>Username:</label>");
            out.write("<input type=\"email\" name=\"useremail\" placeholder=\"yourname@email.com\">");
            out.write("<br>");
            out.write("<label>Password:</label>");
            out.write("<input type=\"password\" name=\"password\" placeholder=\"password\">");
            out.write("<br><br>");
            out.write("<div id=\"loginbtns\">");
            out.write("<input class=\"submitbtn\" type=\"submit\" value=\"Login\">");
            out.write("<input class=\"resetbtn\" type=\"reset\" value=\"Reset\" />");
            out.write("</div>");
            out.write("</form>");
            out.write("<br><br>");
            out.write("</div>");
            out.write("<div id=\"footer\">");
            out.write("<p>copyrights copy; Bikash Baral &#174</p>");
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
