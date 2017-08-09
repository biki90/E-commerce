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
@WebServlet(name = "Registration", urlPatterns = {"/registration"})
public class Registration extends HttpServlet {

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
        String message = (String)request.getAttribute("s");
        if(message==null) message = "";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/layout.css\">\n" +
"        <title>Bikash Finance - Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"wrapper\">\n" +
"            <div id=\"header\">\n" +
"                <h1>Bikash Finance</h1>\n" +
"                <p id=\"login\">You are not logged in.</p>\n" +
"                <ul id=\"nav\">\n" +
"                    <li><a href = home>HOME</a></li>\n" +
"                    <li><a href = login>LOGIN</a></li>\n" +
"                    <li><a href = registration>REGISTER</a></li>\n" +
"                </ul>\n" +
"            </div>\n" +
"            <div id=\"bodypart2\">" +
"                <h2>Customer Registration Form</h2>" + message+
"                <form action=\"Register\"  method=\"POST\" name=\"register\" id=\"registerForm\" onsubmit=\"\">\n" +
"                    <table id=\"register\">\n" +
"                            <tr>\n" +
"                                <td size=\"40\">First Name</td>\n" +
"                                <td><input type=\"text\" name=first_name id=\"textfirstname\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Last Name</td>\n" +
"                                <td><input type=\"text\" name=\"last_name\" id=\"lastname\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Date Of Birth</td>\n" +
"                                <td><input type=\"text\" name=\"dob\" id=\"dob\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Mobile No.</td>\n" +
"                                <td><input type=\"text\" name=\"mobile\" id=\"mobileno\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Sex</td>\n" +
"                                <td><select name=\"Sex\">\n" +
"                                    <option value=\"\" selected>select..</option>                                    \n" +
"                                    <option value=\"Male\">Male</option>\n" +
"                                    <option value=\"Female\">Female</option>\n" +
"                                </select></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Postal Address</td>\n" +
"                                <td><input type=\"text\" name=\"postal_address\" id=\"paddress\" size=\"50\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Personal Address</td>\n" +
"                                <td><input type=\"text\" name=\"personal_address\" id=\"personaladdress\" size=\"50\"></td>\n" +
"                            </tr>                            \n" +
"                            <tr>\n" +
"                                <td size=\"30\">City</td>\n" +
"                                <td><select name=\"city\">\n" +
"                                    <option value=\"\" selected>select..</option>\n" +
"                                    <option value=\"Charlotte\">Charlotte</option>\n" +
"                                    <option value=\"Atlanta\">Atlanta</option>\n" +
"                                    <option value=\"New York City\">New York City</option>\n" +
"                                    <option value=\"Greensboro\">Greensboro</option>\n" +
"                                </select></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">State</td>\n" +
"                                <td><select Name=\"state\">\n" +
"                                    <option value=\"\" selected>select..</option>\n" +
"                                    <option value=\"North Carolina\">North Carolina</option>\n" +
"                                    <option value=\"Georgia\">Georgia</option>\n" +
"                                    <option value=\"New York\">New York </option>\n" +
"                                </select></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Pin Code</td>\n" +
"                                <td><input type=\"text\" name=\"pincode\" id=\"pincode\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Email</td>\n" +
"                                <td><input type=\"email\" name=\"emailid\" id=\"emailid\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td size=\"30\">Username</td>\n" +
"                                <td><input type=\"text\" name=\"username\" id=\"emailid\" size=\"25\"></td>\n" +
"                            </tr>                            \n" +
"                            <tr>\n" +
"                                <td>Password</td>\n" +
"                                <td><input type=\"password\" name=\"password\" id=\"password\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                            <tr>\n" +
"                                <td>Re-Enter Password</td>\n" +
"                                <td><input type=\"password\" name=\"re_entered_password\" id=\"password\" size=\"25\"></td>\n" +
"                            </tr>\n" +
"                        </table>  \n" +
"                    <br><br>\n" +
"                    <div id=\"registerForm_btns\">\n" +
"                        <input class=\"submitbtn\" type=\"submit\" value=\"Submit\">\n" +
"                        <input class=\"resetbtn\" type=\"reset\" value=\"Reset\" />\n" +
"                    </div>\n" + 
"                    </form>    \n" + 
"            </div>\n" +
"        </div>");
            out.println("</body>");
            out.println("</html>");
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
