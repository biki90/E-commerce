/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dbHelpers.BuyStockQuery;
import dbHelpers.CheckStockQuery;
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
import model.Stock;
import model.User;

/**
 *
 * @author Praveena
 */
@WebServlet(name = "BuyShares", urlPatterns = {"/buyShares"})
public class BuyShares extends HttpServlet {

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
        
        String companyID = request.getParameter("companyID");
        int companyid = Integer.parseInt(companyID);
        String shares = request.getParameter("shares");
        int noOfShares = 0;
        if(!"".equals(shares)){
            noOfShares = Integer.parseInt(shares);
        }
        Stock stock_ = new Stock();
        User user_ = new User();
        Boolean buy ;
        
        CheckStockQuery aq = new CheckStockQuery();
        stock_ = aq.doGetSpecificStock(companyid); 
        CheckUserQuery uq = new CheckUserQuery();
        user_ = uq.doGetSpecific(userSession);  
        
        int companyShares = stock_.getShares();
        Double value_of_stocks_bought = stock_.getPrice_per_share() * noOfShares;
        int sharesRemaining = companyShares - noOfShares;
        Double totalFunds = user_.getFunds() - value_of_stocks_bought;
        String holdings = user_.getHoldings();
        String g = holdings;
        String r = "";
        String companyName = "";   
        int sharesTotal = noOfShares;
        String url="";
        Double previousStockValue = user_.getValue_of_holdings();
        Double newValueofStocks = previousStockValue + value_of_stocks_bought;
        
        if( noOfShares <= companyShares && user_.getFunds() >= value_of_stocks_bought){
            BuyStockQuery bq = new BuyStockQuery();
            bq.doUpdateStock(companyid, sharesRemaining );
            companyName = bq.getCompany(companyid);
            int p=-1;
            String h[] = null;
            int leng = 0;
            
            if(holdings!=null){
                h = holdings.split(",");
                leng = h.length;
                for(int i=0;i<h.length;i++){
                    String n[] = h[i].split("-");
                    if(n[0].equals(companyName)){
                        sharesTotal = noOfShares + Integer.parseInt(n[1]);
                        p=i;
                        break;
                    }                
                }
                r = companyName + "-"+ sharesTotal;
                if(p==-1){
                    r = g +"," +r;
                }
                else{
                    for(int j=0;j<leng;j++){
                        if(j==p)
                            r = r;
                        else
                            r = h[j] +"," +r;
                    }
                }
            }
            else{
                r = companyName + "-"+ sharesTotal;
            }   
            
            holdings = r;
            bq.doUpdateUser(user_.getUserID(),totalFunds,holdings,newValueofStocks);
            url = "/stocks";
        }
        else{
            url="/stocks";
        }
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
