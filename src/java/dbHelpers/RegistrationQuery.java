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
import java.sql.SQLException;
import model.User;

/**
 *
 * @author admin
 */
public class RegistrationQuery {
    
    private Connection connection;
    
    public RegistrationQuery(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            PropertyReader propReader = new PropertyReader();            
            this.connection = DriverManager.getConnection(propReader.readProperty("dbconnectionstring"),propReader.readProperty("dbusername"),propReader.readProperty("dbpassword"));
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        }
    }
    
    public void doAdd(User user){
        
        //setup a string to hold our query
        String query = "INSERT INTO users (username, password, email, first_name, last_name, postal_address, personal_address, sex, city, state, pincode, dob, mobile,joined_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";        
        
        try {
            //create a prepared statement using our query string
            PreparedStatement ps = this.connection.prepareStatement(query);
            
            //fill in the prepared statement
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); 
            ps.setString(3, user.getUseremail()); 
            ps.setString(4, user.getFirst_name()); 
            ps.setString(5, user.getLast_name()); 
            ps.setString(6, user.getPostal_address()); 
            ps.setString(7, user.getPersonal_address());
            ps.setString(8, user.getSex());
            ps.setString(9, user.getCity());
            ps.setString(10, user.getState());
            ps.setString(11, user.getPincode());
            ps.setString(12, user.getDob());
            ps.setString(13, user.getMobile());
            ps.setString(14, user.getJoinedDate());
            
            //execute the query
            ps.executeUpdate();
            
        } catch (SQLException ex) {
        }
    }
    
}
