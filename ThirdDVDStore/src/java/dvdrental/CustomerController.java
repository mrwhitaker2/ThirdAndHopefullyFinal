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
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerController"})
public class CustomerController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String WELCOME = "/welcome.jsp";
    private static String CREATE_CUSTOMER = "/CustomerCreate.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    private static String EMP_LOGIN = "/EmployeeLogin.jsp";
    private static String BROWSE = "/CustomerBrowse.jsp";
    private static String VIEW_CUST = "/CustomerProfile.jsp";
    private static String VIEW_CART = "/ShoppingCart.jsp";
    private static String MOVIE_DETAILS = "/MovieDetails.jsp";
    private static String CHECKOUT_RESULT = "/CheckoutResult.jsp";
    private static String SHOPPING_CART = "/ShoppingCart.jsp";
    private static String RESULTS = "/SearchResults.jsp";
    private static String CHECKOUT_DETAILS = "/CheckoutDetails.jsp";
    private static String WISHLIST = "/Wishlist.jsp";

    private CustomerDAO dao;
    private FilmDAO FilmDao;

    private static ArrayList<Customer> checkoutdetails = new ArrayList<Customer>();

    Customer customer = new Customer(); //this is the current customer that will be making transactions 

    public CustomerController() {
        super();
        dao = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        HttpSession ses = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (action.equalsIgnoreCase("custlogin")) {
            forward = CUST_LOGIN;
        } else if (action.equalsIgnoreCase("welcome")) {
            forward = WELCOME;
        } else if (action.equalsIgnoreCase("browse")) {
            forward = BROWSE;
        } else if (action.equalsIgnoreCase("emplogin")) {
            forward = EMP_LOGIN;
        } else if (action.equalsIgnoreCase("viewcustomers")) {

            dao.getCustomerList();
            forward = VIEW_CUST;
            request.setAttribute("customers", dao.getCustomers());

        } else if (action.equalsIgnoreCase("custcreate")) {
            forward = CREATE_CUSTOMER;
        } else if (action.equalsIgnoreCase("viewdetails")) {

            String film_id = request.getParameter("film_id");
            FilmDao.getDetails(film_id);
            forward = MOVIE_DETAILS;
            request.setAttribute("filmdetails", FilmDao.getFilmDetails());

        } else if (action.equalsIgnoreCase("addcart")) {

            int customer_id = customer.getCustomer_Id();
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            FilmDao.addCart(customer_id, film_id);
            FilmDao.viewCart(customer_id);

            Customer customer3 = new Customer();
            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setUsername(customer.getUsername());
            customer3.setCustomer_Id(customer.getCustomer_Id());
            customer3.setTotal(Total);
            ArrayList<Customer> checkoutdetails1 = new ArrayList<Customer>();
            checkoutdetails1.add(customer3);

            request.setAttribute("checkoutdetails", checkoutdetails1);
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
            ArrayList<Customer> checkoutdetails1 = new ArrayList<Customer>();
            checkoutdetails1.add(customer3);

            request.setAttribute("checkoutdetails", checkoutdetails1);

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
            ArrayList<Customer> checkoutdetails1 = new ArrayList<Customer>();
            checkoutdetails1.add(customer3);
            request.setAttribute("checkoutdetails", checkoutdetails1);
            forward = SHOPPING_CART;

        } else if (action.equalsIgnoreCase("checkoutdetails")) {

            Customer customer3 = new Customer();

            int customer_id = customer.getCustomer_Id();
            customer3.setCustomer_Id(customer_id);

            String Username = customer.getUsername();
            customer3.setUsername(Username);

            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setTotal(Total);

            ArrayList<Customer> checkoutdetails2 = new ArrayList<Customer>();
            checkoutdetails2.add(customer3);
            request.setAttribute("checkoutdetails", checkoutdetails2);

            forward = CHECKOUT_DETAILS;

        } else if (action.equalsIgnoreCase("addwishlist")){
            
            int customer_id = customer.getCustomer_Id();
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            FilmDao.addWishlist(customer_id, film_id);
            FilmDao.viewWishlist(customer_id);

            Customer customer3 = new Customer();
            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setUsername(customer.getUsername());
            customer3.setCustomer_Id(customer.getCustomer_Id());
            customer3.setTotal(Total);
            ArrayList<Customer> checkoutdetails1 = new ArrayList<Customer>();
            checkoutdetails1.add(customer3);

            ses.setAttribute("checkoutdetails", checkoutdetails1);
            ses.setAttribute("wishlistfilms", FilmDao.getWishlistDetails());
            forward = WISHLIST;
            
        }else if (action.equalsIgnoreCase("deletewishlist")){
            
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            int customer_id = customer.getCustomer_Id();
            FilmDao.deleteWish(customer_id, film_id);
            FilmDao.viewWishlist(customer_id);
            ses.setAttribute("wishlistfilms", FilmDao.getWishlistDetails());
            forward = WISHLIST;
            
        }
        else {
            forward = CUST_LOGIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession ses = request.getSession(true);
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

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
            customer.setPayment(Payment);
            customer.setPayment_Amount(Payment_Amount);
            int customer_id = customer.getCustomer_Id();
            String Username = customer.getUsername();
            double Total = FilmDao.calculateTotal(customer_id);
            customer.setTotal(Total);

            double result = FilmDao.calculateChange(Total, Payment_Amount);
            BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_EVEN);
            result = bd.doubleValue();
            ses.setAttribute("result", result);
            
            FilmDao.getFilmsBought(customer_id);
            ses.setAttribute("filmsbought", FilmDao.getFilmsBought());
            
            FilmDao.deleteCartInfo(customer_id);

            RequestDispatcher rs = request.getRequestDispatcher(CHECKOUT_RESULT);
            rs.forward(request, response);
        } else if (action.equalsIgnoreCase("createCust")) {

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
                Customer newCust = new Customer();
                newCust = dao.getCustomerID(Username, Password);
                int customer_id = newCust.getCustomer_Id();
                RequestDispatcher view = request.getRequestDispatcher(BROWSE);
                ses.setAttribute("Username", Username);
                ses.setAttribute("Customer_Id", customer_id);
                view.forward(request, response);
            } else {

                RequestDispatcher view = request.getRequestDispatcher(CREATE_CUSTOMER);
                view.forward(request, response);
            }

        }

    }  

}
