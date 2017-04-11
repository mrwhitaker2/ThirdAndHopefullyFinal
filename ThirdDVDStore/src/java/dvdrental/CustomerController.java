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
    private static String VIEW_CUST = "/CustomerProfile.jsp";

    
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

        } else if (action.equalsIgnoreCase("emplogin")) {
            forward = EMP_LOGIN;
        } else if (action.equalsIgnoreCase("viewcustomers")){
            forward = VIEW_CUST;
        }

//        } else if (action.equalsIgnoreCase("custverify")) {
//            String Username = (request.getParameter("Username"));
//            String Password = (request.getParameter("Password"));
//          //  Customer customer = dao.verifyCustomer(Username, Password);
//
//            if (customer == null) {
//                forward = CUST_LOGIN;
//                System.out.print(customer.getUsername());
//            } else {
//                //Customer customer = dao.getCustomer(Username);
//                request.setAttribute("customer", customer);
//                forward = BROWSE;
//            }
//
//        } else {
            //forward = CREATE_CUSTOMER;
       // }
        
        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();

        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Customer_Pref = request.getParameter("Customer_Pref");
        String Payment = request.getParameter("Payment");
        String Email = request.getParameter("Email");

        customer.setUsername(Username);
        customer.setPassword(Password);
        customer.setCustomer_Pref(Customer_Pref);
        customer.setPayment(Payment);
        customer.setEmail(Email);

        if (Username != null && Password != null && Customer_Pref != null
                && Payment != null && Email != null) {

            dao.addCustomer(customer);

            RequestDispatcher view = request.getRequestDispatcher(BROWSE);
            // request.setAttribute("products", dao.getAllProducts());
            view.forward(request, response);
        }
        else{
            
            RequestDispatcher view = request.getRequestDispatcher(CREATE_CUSTOMER);
            view.forward(request, response);
            
        }

    }
    
     protected void login (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();

        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");

        customer.setUsername(Username);
        customer.setPassword(Password);

        if (Username != null && Password != null) {

            //dao.verifyCustomer(Username, Password);

            RequestDispatcher view = request.getRequestDispatcher(BROWSE);
            // request.setAttribute("products", dao.getAllProducts());
            view.forward(request, response);
        }
        else{
            
            RequestDispatcher view = request.getRequestDispatcher(CUST_LOGIN);
            view.forward(request, response);
            
        }

    }

}
