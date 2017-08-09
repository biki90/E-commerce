/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dbHelpers.RegistrationQuery;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import model.User;

/**
 *
 * @author Praveena
 */
public class CheckRegistrationServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        String url = "/registration";
        String s = "<div class=\"alert\"><p>Please fill all the fields</p></div>";
        
        String firstname = request.getParameter("first_name");
        String lastname = request.getParameter("last_name");
        String dob = request.getParameter("dob");
        String mobile = request.getParameter("mobile");
        String sex = request.getParameter("sex");
        String postal_address = request.getParameter("postal_address");
        String personal_address = request.getParameter("personal_address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String emailid = request.getParameter("emailid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_entered_password = request.getParameter("re_entered_password");
        String joinedDate = "";
        User user = new User();
        
        //Form validation
        if(!"".equals(firstname)){
            user.setFirst_name(firstname);
            if(!"".equals(lastname)){
                user.setLast_name(lastname);
                if(!"".equals(dob)){
                    user.setDob(dob);
                    if(!"".equals(mobile)){
                        user.setMobile(mobile);
                        if(!"".equals(sex)){
                            user.setSex(sex);
                            if(!"".equals(postal_address)){
                                user.setPostal_address(postal_address);
                                if(!"".equals(personal_address)){
                                    user.setPersonal_address(personal_address);
                                    if(!"".equals(city)){
                                        user.setCity(city);
                                        if(!"".equals(state)){
                                            user.setState(state);
                                            if(!"".equals(pincode)){
                                                user.setPincode(pincode);
                                                if(!"".equals(emailid)){
                                                    user.setUseremail(emailid);
                                                    if(!"".equals(username)){
                                                        user.setUsername(username);
                                                        if(!"".equals(password) &&!"".equals(re_entered_password) && password.equals(re_entered_password)){
                                                            user.setPassword(password);
                                                            user.setRe_entered_password(re_entered_password);   
                                                            RegistrationQuery aq = new RegistrationQuery();
                                                            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                                            Date date = new Date();
                                                            joinedDate = dateFormat.format(date);
                                                            user.setJoinedDate(joinedDate);
                                                            aq.doAdd(user);  
                                                            url = "/login";
                                                            s = "<div class=\"success\"><p>You have been registered Successfully!!!!<br>Please login to continue</p></div>";
                                                            request.setAttribute("user", user);
                                                        }
                                                        else{
                                                            s = "<div class=\"alert\"><p>Password mismatch!!!</p></div>";
                                                        }
                                                    } 
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }        
        }else{
            s = "<div class=\"alert\"><p>Please fill all the fields</p></div>";
        }
        
        request.setAttribute("s", "<br>"+s);               
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response); 
        
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
