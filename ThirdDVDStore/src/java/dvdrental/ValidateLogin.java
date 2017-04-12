/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrwhi
 */
public class ValidateLogin {
    
    private static ResultSet rs;
    private static List<Customer> customers = new ArrayList<Customer>();

    public static boolean checkCustomer(String Username, String Password) {
        boolean st = false;
        Customer customer = new Customer();
       
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement("select * from customernobs where Username=? and Password=?");
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();         
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    
    public static boolean checkEmployee(String Username, String Password) {
        boolean st = false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement("select * from staffnobs where Username=? and Password=?");
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    
     public static Customer searchCustomer(String Username, String Password) {
         
         Customer customer = new Customer();
         
         
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT * from CustomerNoBS where Username=? and Password =?");       
            ps.setString(1, Username);
            ps.setString(2, Password);
            
            rs = ps.executeQuery();
             
            while (rs.next()) {
               
                customer.setCustomer_Id(rs.getInt("Customer_Id"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setCustomer_Pref(rs.getString("Customer_Pref"));
                customer.setPayment(rs.getString("Payment"));
                customer.setEmail(rs.getString("Email"));
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return customer;
        
    }
      
}
