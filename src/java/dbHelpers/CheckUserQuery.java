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
import model.User;

/**
 *
 * @author admin
 */
public class CheckUserQuery {
    
    private Connection connection;
    private ResultSet result;      
    User user_ = new User();
    
    public CheckUserQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PropertyReader propReader = new PropertyReader();            
            this.connection = DriverManager.getConnection(propReader.readProperty("dbconnectionstring"),propReader.readProperty("dbusername"),propReader.readProperty("dbpassword"));
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            
        }
    }
    
    public User doCheck(User user){
        
        int login = 0;
        String username = "";  
        String email = user.getUseremail();
        String password = user.getPassword();
        
        String query = "SELECT username, user_id FROM users WHERE email = ? AND password = ?";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            
            //execute the query
            this.result = ps.executeQuery();
            
            if(this.result.next()){
                username = this.result.getString("username");
                login = this.result.getInt("user_id");
                this.user_.setUserID(login);
                this.user_.setUsername(username);
                this.user_.setUseremail(email);
                this.user_.setPassword(password);
            }  
        }
        catch (SQLException ex) {
        }
        return this.user_;
    }
    
    public User getUser(){
        return this.user_;
    }
    
    public User doGet(User user){       
        
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, user.getUseremail());
            ps.setString(2, user.getPassword());
            
            //execute the query
            this.result = ps.executeQuery();
            
            if(this.result.next()){
                user_.setUserID(this.result.getInt("user_id"));
                user_.setFirst_name(this.result.getString("first_name"));
                user_.setLast_name(this.result.getString("last_name"));
                user_.setDob(this.result.getString("dob"));
                user_.setMobile(this.result.getString("mobile"));
                user_.setSex(this.result.getString("sex"));
                user_.setPostal_address(this.result.getString("postal_address"));
                user_.setPersonal_address(this.result.getString("personal_address"));
                user_.setCity(this.result.getString("city"));
                user_.setState(this.result.getString("state"));
                user_.setPincode(this.result.getString("pincode"));
                user_.setJoinedDate(this.result.getString("joined_date"));
                user_.setUseremail(this.result.getString("email"));
                user_.setUsername(this.result.getString("username"));
                user_.setFunds(this.result.getDouble("funds"));
                user_.setHoldings(this.result.getString("holdings"));
                user_.setValue_of_holdings(this.result.getDouble("value_of_holdings"));
            }
        }
        catch (SQLException ex) {
        }
        return user_;
    }       
    
    public User doGetSpecific(User user){       
        
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, user.getUseremail());
            ps.setString(2, user.getPassword());
            
            //execute the query
            this.result = ps.executeQuery();
            
            if(this.result.next()){
                user_.setUserID(this.result.getInt("user_id"));
                user_.setFirst_name(this.result.getString("first_name"));
                user_.setLast_name(this.result.getString("last_name"));
                user_.setDob(this.result.getString("dob"));
                user_.setMobile(this.result.getString("mobile"));
                user_.setSex(this.result.getString("sex"));
                user_.setPostal_address(this.result.getString("postal_address"));
                user_.setPersonal_address(this.result.getString("personal_address"));
                user_.setCity(this.result.getString("city"));
                user_.setState(this.result.getString("state"));
                user_.setPincode(this.result.getString("pincode"));
                user_.setJoinedDate(this.result.getString("joined_date"));
                user_.setUseremail(this.result.getString("email"));
                user_.setUsername(this.result.getString("username"));
                user_.setFunds(this.result.getDouble("funds"));
                user_.setHoldings(this.result.getString("holdings"));
                user_.setValue_of_holdings(this.result.getDouble("value_of_holdings"));
            }
        }
        catch (SQLException ex) {
        }
        return user_;
    } 
}
