/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import configuration.PropertyReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Stock;

/**
 *
 * @author admin
 */
public class CheckStockQuery {
    
    private Connection connection;
    private ResultSet result;      
    Stock stock = new Stock();
    
    public CheckStockQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PropertyReader propReader = new PropertyReader();            
            this.connection = DriverManager.getConnection(propReader.readProperty("dbconnectionstring"),propReader.readProperty("dbusername"),propReader.readProperty("dbpassword"));
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(CheckStockQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public Stock getStock(){
        return this.stock;
    }
    
    public Stock doGet(){       
        
        String query = "SELECT * FROM stocks";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            
            //execute the query
            this.result = ps.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(CheckStockQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stock;
    }       
    
    public String getHTMLString(){
        String table="";
        table+="<table id=\"stock\">";
        table+="<thead>";
        table+="<tr class=\"mastLine\">";        
        table+="<th>";
        table+="Company ID";
        table+="</th>";
        table+="<th>";
        table+="Company";
        table+="</th>";
        table+="<th>";
        table+="Shares";
        table+="</th>";
        table+="<th>";
        table+="Price per share";
        table+="</th>";  
        table+="<th>";
        table+="Buy Shares";
        table+="</th>";
        table+="</tr>";
        table+="</thead>";
        Stock stock_ = new Stock();
        
        try {
            while(this.result.next()){
                stock_.setCompanyID(this.result.getInt("company_id"));
                stock_.setCompany(this.result.getString("company"));
                stock_.setShares(this.result.getInt("shares"));
                stock_.setPrice_per_share(this.result.getDouble("price_per_share"));
                                
                table+="<tbody>";
                table+="<tr>";
                table+="<td>";
                table+=stock_.getCompanyID();
                table+="</td>";
                table+="<td>";
                table+=stock_.getCompany();
                table+="</td>";
                table+="<td>";
                table+=stock_.getShares();
                table+="</td>";
                table+="<td>";
                table+=stock_.getPrice_per_share();
                table+="</td>";
                table+="<td>";
                table+="<form id=\"buyShares\" action=\"buyShares?companyID="+stock_.getCompanyID()+"\" method=\"POST\"><input id=\"shares\" type=\"text\" name=\"shares\" width=\"5px\"><input id=\"buybtn\" class=\"submitbtn\" type=\"submit\" value=\"Buy\"></form>";
                table+="</td>";
                table+="</tr>"; 
                table+="</tbody>";
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckStockQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table+="</table>";
        return table;
    }
    
    public Stock doGetSpecificStock(int companyID){       
        
        String query = "SELECT * FROM stocks where company_id = ?";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            
            ps.setInt(1,companyID );
            
            //execute the query
            this.result = ps.executeQuery();
            
            while(this.result.next()){
                this.stock.setCompanyID(this.result.getInt("company_id"));
                this.stock.setCompany(this.result.getString("company"));
                this.stock.setShares(this.result.getInt("shares"));
                this.stock.setPrice_per_share(this.result.getDouble("price_per_share"));
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(CheckStockQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stock;
    }
    
}
