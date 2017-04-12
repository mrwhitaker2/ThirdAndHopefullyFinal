/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mrwhi
 */
@WebServlet(name = "CustLoginController", urlPatterns = {"/CustLoginController"})
public class CustLoginController extends HttpServlet {

    private static String BROWSE = "/CustomerBrowse.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Customer customer = new Customer(); //this is the current customer that will be making transactions 

        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        customer.setUsername(Username);
        customer.setPassword(Password);
        
        
        if(ValidateLogin.checkCustomer(Username, Password)){
            
            Customer customer1 = new Customer();
            customer1 = ValidateLogin.searchCustomer(Username, Password);
            
            customer.setCustomer_Id(customer1.getCustomer_Id());
            customer.setUsername(customer1.getUsername());
            customer.setPassword(customer1.getPassword());
            customer.setCustomer_Pref(customer1.getCustomer_Pref());
            customer.setPayment(customer1.getPayment());
            customer.setEmail(customer1.getEmail());
            
            //request.setAttribute("customer", customer);
            RequestDispatcher rs = request.getRequestDispatcher(BROWSE);
            rs.forward(request, response);
            
        }
            else {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher(CUST_LOGIN);
            rs.include(request, response);
            }
    }


}

