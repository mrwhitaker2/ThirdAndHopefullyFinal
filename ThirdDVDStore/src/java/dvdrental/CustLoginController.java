/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mrwhi
 */
@WebServlet(name = "CustLoginController", urlPatterns = {"/CustLoginController"})
public class CustLoginController extends HttpServlet {

    private static String BROWSE = "/CustomerBrowse.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    private static String SHOPPING_CART = "/ShoppingCart.jsp";
    private static String RESULTS = "/SearchResults.jsp";
    private static String CHECKOUT_DETAILS = "/CheckoutDetails.jsp";

    private static ArrayList<Customer> checkoutdetails = new ArrayList<Customer>();
    private FilmDAO FilmDao;

    Customer customer = new Customer(); //this is the current customer that will be making transactions 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        HttpSession ses = request.getSession(true);

        if (action.equalsIgnoreCase("login")) {

            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");
            customer.setUsername(Username);
            customer.setPassword(Password);
            int customer_id = 0;

            if (ValidateLogin.checkCustomer(Username, Password)) {

                Customer customer1 = new Customer();
                customer1 = ValidateLogin.searchCustomer(Username, Password);

                customer_id = customer1.getCustomer_Id();

                customer.setCustomer_Id(customer_id);
                customer.setUsername(customer1.getUsername());
                customer.setPassword(customer1.getPassword());
                customer.setCustomer_Pref(customer1.getCustomer_Pref());
                customer.setPayment(customer1.getPayment());
                customer.setEmail(customer1.getEmail());

                ses.setAttribute("Username", Username);
                ses.setAttribute("Customer_Id", customer_id);
                RequestDispatcher rs = request.getRequestDispatcher(BROWSE);
                rs.forward(request, response);

            } else {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher(CUST_LOGIN);
                rs.include(request, response);
            }
        } else if (action.equalsIgnoreCase("checkout")) {

            String Payment = request.getParameter("payment");
            String Payment_Amount = request.getParameter("Payment_Amount");
            int customer_id = customer.getCustomer_Id();
            String Username = customer.getUsername();
            double Total = customer.getTotal();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession ses = request.getSession(true);

        String action = request.getParameter("action");
        String forward = "";

        if (action.equalsIgnoreCase("addcart")) {

            int customer_id = customer.getCustomer_Id();
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            FilmDao.addCart(customer_id, film_id);
            FilmDao.viewCart(customer_id);
            request.setAttribute("cartfilms", FilmDao.getCartDetails());
            forward = SHOPPING_CART;

        } else if (action.equalsIgnoreCase("viewcart")) {

            int customer_id = customer.getCustomer_Id();
            FilmDao.viewCart(customer_id);
            request.setAttribute("cartfilms", FilmDao.getCartDetails());

            Customer customer3 = new Customer();
            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setUsername(customer.getUsername());
            customer3.setCustomer_Id(customer.getCustomer_Id());
            customer3.setTotal(Total);
            checkoutdetails.add(customer3);

            request.setAttribute("checkoutdetails", checkoutdetails);

            forward = SHOPPING_CART;

        } else if (action.equalsIgnoreCase("deletecart")) {
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            int customer_id = customer.getCustomer_Id();
            FilmDao.deleteFilm(customer_id, film_id);
            FilmDao.viewCart(customer_id);
            request.setAttribute("cartfilms", FilmDao.getCartDetails());

            Customer customer3 = new Customer();
            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setTotal(Total);
            checkoutdetails.add(customer3);
            request.setAttribute("checkoutdetails", checkoutdetails);
            forward = SHOPPING_CART;

        } else {
            forward = CUST_LOGIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }
}
