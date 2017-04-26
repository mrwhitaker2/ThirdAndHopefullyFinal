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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrwhi
 */
public class CustomerDAO {
     private static ResultSet rs;
     private static List<Customer> customers = new ArrayList<Customer>();
    
     private Connection connection;

    public CustomerDAO() {
        connection = DBConnectionUtil.getConnection();
    }

    public void addCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into CustomerNoBS(Username,Password,Customer_Pref,Payment,Email) values ( ?, ?, ?, ?, ? )");
          
            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getCustomer_Pref());
            preparedStatement.setString(4, customer.getPayment());
            preparedStatement.setString(5, customer.getEmail());
            

            preparedStatement.executeUpdate();
            
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void getCustomerList() {
        customers.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM CustomerNoBS");
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_Id(rs.getInt("Customer_Id"));
                customer.setUsername(rs.getString("Username"));
                customer.setPassword(rs.getString("Password"));
                customer.setCustomer_Pref(rs.getString("Customer_Pref"));
                customer.setPayment(rs.getString("Payment"));
                customer.setEmail(rs.getString("Email"));
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Customer> getCustomers() {

        return customers;

    }
//    public Customer verifyCustomer (String Username, String Password){
//        
//        Boolean isVerified = false;
//        Customer customer = new Customer();
//        
//          try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("select * from CustomerNoBS where Username=? and Password=?");
//            
//            preparedStatement.setString(1, Username);
//            preparedStatement.setString(2, Password);
//
//           int updateCheck = preparedStatement.executeUpdate();     
//           if(updateCheck != 0){  
//               
//               isVerified = true;
//               Statement stm;
//               stm = connection.createStatement();
//               String sql = "select * from CustomerNoBS where username =" + Username;
//               ResultSet rst;
//               rst = stm.executeQuery(sql);
//               while(rst.next())
//               {
//                   customer.setCustomer_Id(rst.getInt("Customer_Id"));
//                   customer.setUsername(rst.getString("Username"));
//                   customer.setPassword(rst.getString("Password"));
//                   customer.setCustomer_Pref(rst.getString("Customer_Pref"));
//                   customer.setPayment(rst.getString("Payment"));
//                   customer.setEmail(rst.getString("Email"));
//               }
//           }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//          
//          
//          return customer;
//        
//    }
    
    public Customer getCustomer (String Username){
        
        Customer customer = new Customer();
        
        //customer.setCustomer_Id();
        customer.setUsername(Username);
       // customer.setPassword()
        
        
        
        return customer;
        
    }
}
