/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import dbHelpers.CheckUserQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Bikash
 */
@WebServlet(name = "Usermenu", urlPatterns = {"/usermenu"})
public class Usermenu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        User userSession = (User)session.getAttribute("user");
        
        User user_ = new User();
        User user = new User();
        user.setUseremail(userSession.getUseremail());
        user.setPassword(userSession.getPassword());
        
        //create an CheckAdminQuery object and use it to check for login credentials
        CheckUserQuery aq = new CheckUserQuery();
        user_ = aq.doGet(user);    
        int login = user_.getUserID();        
        String url="";
        
        if(!(login==0)){ 
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
    "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\">\n" +
    "        <title>Bikash Finance - User Menu</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<div id=\"wrapper\">\n" +
    "            <div id=\"header\">\n" +
    "                <h1>Bikash Finance</h1>\n" +
    "                <div id=\"login\"><p>You are logged in as "+ userSession.getUsername()+ "</p><br>\n" +
    "                <a href = login >Logout</a></div>\n" +
    "                <ul id=\"nav\">\n" +
    "                    <li><a href = stocks?user="+user_+">STOCKS</a></li>\n" +
    "                    <li><a href= # >USERMENU</a></li>\n" +
    "                </ul>\n" +
    "            </div>\n" +
    "            <div id=\"bodypart\">                \n" +
    "                <div id=\"bodyright\">\n" +
    "                    <h2>User Information</h2>\n" +
    "                    <table id=\"usermenu\" >\n" +
    "                            <tr>\n" +
    "                                <td>First name</td>\n" +
    "                                <td>"+user_.getFirst_name()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>Last name</td>\n" +
    "                                <td>"+user_.getLast_name()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>Personal Address</td>\n" +
    "                                <td>"+user_.getPersonal_address()+"</td>\n" +
    "                            </tr> \n" +
    "                            <tr>\n" +
    "                                <td>Email</td>\n" +
    "                                <td>"+user_.getUseremail()+"</td>\n" +
    "                            </tr>                           \n" +
    "                            <tr>\n" +
    "                                <td>UserName</td>\n" +
    "                                <td>"+user_.getUsername()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>User since </td>\n" +
    "                                <td>"+user_.getJoinedDate()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>Account Balance </td>\n" +
    "                                <td>"+user_.getFunds()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>Holdings</td>\n" +
    "                                <td>"+user_.getHoldings()+"</td>\n" +
    "                            </tr>\n" +
    "                            <tr>\n" +
    "                                <td>Value of Holdings </td>\n" +
    "                                <td>"+user_.getValue_of_holdings()+"</td>\n" +
    "                            </tr>\n" +
    "                        </table>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else if(login==0){
            url="/login";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
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
