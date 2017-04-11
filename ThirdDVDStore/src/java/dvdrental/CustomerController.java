<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String WELCOME = "/welcome.jsp";
    private static String CREATE_CUSTOMER = "/CustomerCreate.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    private static String EMP_LOGIN = "/EmployeeLogin.jsp";
    private static String BROWSE = "/CustomerBrowse.jsp";
   
    private CustomerDAO dao;

   
    public CustomerController() {
        super();
        dao = new CustomerDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");
        
        String search = request.getParameter("search");

        if (action.equalsIgnoreCase("custlogin")) {
           
            forward = CUST_LOGIN;
            
        } else if (action.equalsIgnoreCase("welcome")) {
            forward = WELCOME;
          
        } else if (action.equalsIgnoreCase("browse")) {
            forward = BROWSE;
          
      }
         else if (action.equalsIgnoreCase("emplogin")) {
            forward = EMP_LOGIN;
           
      } 
        else {
            forward = CREATE_CUSTOMER;
        }
        
        

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setUsername(request.getParameter("Username"));
        customer.setPassword(request.getParameter("Password"));
        customer.setCustomer_Pref(request.getParameter("Customer_Pref"));
        customer.setPayment(request.getParameter("Payment"));
        customer.setEmail(request.getParameter("Email"));
        
       
            dao.addCustomer(customer);
        
       
 
        RequestDispatcher view = request.getRequestDispatcher(BROWSE);
       // request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
    
 

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String WELCOME = "/welcome.jsp";
    private static String CREATE_CUSTOMER = "/CustomerCreate.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    private static String EMP_LOGIN = "/EmployeeLogin.jsp";
    private static String BROWSE = "/CustomerBrowse.jsp";
   
    private CustomerDAO dao;

   
    public CustomerController() {
        super();
        dao = new CustomerDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");
        
        String search = request.getParameter("search");

        if (action.equalsIgnoreCase("custlogin")) {
            forward = CUST_LOGIN;
        } else if (action.equalsIgnoreCase("welcome")) {
            forward = WELCOME;
        } else if (action.equalsIgnoreCase("browse")) {
            forward = BROWSE;           
      }
         else if (action.equalsIgnoreCase("emplogin")) {
            forward = EMP_LOGIN;
      } 
        else {
            forward = CREATE_CUSTOMER;
        }
        
        

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setUsername(request.getParameter("Username"));
        customer.setPassword(request.getParameter("Password"));
        customer.setCustomer_Pref(request.getParameter("Customer_Pref"));
        customer.setPayment(request.getParameter("Payment"));
        customer.setEmail(request.getParameter("Email"));
        
       
            dao.addCustomer(customer);
        
       
 
        RequestDispatcher view = request.getRequestDispatcher(BROWSE);
       // request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
    
 

}
>>>>>>> refs/remotes/origin/MadelinesBranch
