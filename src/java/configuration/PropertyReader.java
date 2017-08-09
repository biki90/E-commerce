/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class PropertyReader {
    Properties properties = new Properties();
    
    public PropertyReader(){
        try {                
            properties.load(getClass().getClassLoader().getResourceAsStream("configuration/config.properties"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public String readProperty(String propertyName){  
        return  properties.getProperty(propertyName);
    }
}
