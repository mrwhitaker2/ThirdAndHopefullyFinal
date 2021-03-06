
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "CustomerController", urlPatterns =
{
    "/CustomerController"
})
public class CustomerController extends HttpServlet
{

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
    private static String WISHLIST = "/Wishlist.jsp";
    private static String RETURN = "/Return.jsp";
    private static String RETURN_RESULTS = "/ReturnResults.jsp";
    private static String RENTAL_HISTORY = "/RentalHistory.jsp";

    private CustomerDAO dao;
    private FilmDAO FilmDao;

    private static ArrayList<Customer> checkoutdetails = new ArrayList<Customer>();

    Customer customerCurrent = new Customer(); //this is the current customer that will be making transactions 

    public CustomerController()
    {
        super();
        dao = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String forward = "";
        String action = request.getParameter("action");
        HttpSession ses = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (action.equalsIgnoreCase("custlogin"))
        {
            String message="Customer Login";
            forward = CUST_LOGIN;
            ses.setAttribute("message", message);
        } else if (action.equalsIgnoreCase("welcome"))
        {
            forward = WELCOME;
        } else if (action.equalsIgnoreCase("browse"))
        {
            forward = BROWSE;
        } else if (action.equalsIgnoreCase("emplogin"))
        {
            String message = "Employee Login";
            ses.setAttribute("message", message);
            forward = EMP_LOGIN;
        } else if (action.equalsIgnoreCase("viewcustomers"))
        {

            dao.getCustomerList();
            forward = VIEW_CUST;
            request.setAttribute("customers", dao.getCustomers());

        } else if (action.equalsIgnoreCase("custcreate"))
        {
            forward = CREATE_CUSTOMER;
        } else if (action.equalsIgnoreCase("viewdetails"))
        {

            String film_id = request.getParameter("film_id");
            FilmDao.getDetails(film_id);
            forward = MOVIE_DETAILS;
            request.setAttribute("filmdetails", FilmDao.getFilmDetails());

        } else if (action.equalsIgnoreCase("addcart"))
        {

            int customer_id = customerCurrent.getCustomer_Id();
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            ArrayList<Film> filmCheck = new ArrayList<Film>();
            filmCheck = FilmDao.checkMax5(customer_id);
            if (filmCheck.size() <= 4)
            {

                String message = "Enjoy your selections!";
                FilmDao.addCart(customer_id, film_id);
                FilmDao.viewCart(customer_id);
                request.setAttribute("cartfilms", FilmDao.getCartDetails());
                ses.setAttribute("message", message);
            } else if (filmCheck.size() > 4)
            {

                String message = "You can only checkout 5 movies at a time";
                FilmDao.viewCart(customer_id);
                request.setAttribute("cartfilms", FilmDao.getCartDetails());
                ses.setAttribute("message", message);
            }

            forward = SHOPPING_CART;

        } else if (action.equalsIgnoreCase("viewcart"))
        {

            String message = "Enjoy your selections!";

            int customer_id = customerCurrent.getCustomer_Id();
            FilmDao.viewCart(customer_id);
            request.setAttribute("cartfilms", FilmDao.getCartDetails());
            ses.setAttribute("message", message);
            forward = SHOPPING_CART;

        } else if (action.equalsIgnoreCase("deletecart"))
        {
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            int customer_id = customerCurrent.getCustomer_Id();
            FilmDao.deleteFilm(customer_id, film_id);
            FilmDao.viewCart(customer_id);
            String message = "Enjoy your selections!";
            request.setAttribute("cartfilms", FilmDao.getCartDetails());
            ses.setAttribute("message", message);
            forward = SHOPPING_CART;
        } else if (action.equalsIgnoreCase("checkout"))
        {

            int customer_id = customerCurrent.getCustomer_Id();
            String Payment = customerCurrent.getPayment();

            LocalDate localDate = LocalDate.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formatDate = localDate.format(formatter);
            LocalDate parseDate = LocalDate.parse(formatDate, formatter);

            FilmDao.getBoughtFromTable(customer_id);
            ArrayList<Film> filmsbought = new ArrayList<Film>();
            filmsbought = FilmDao.getFilmsBought();
            Film f2 = new Film();

            for (Film f : filmsbought)
            {
                f2.setFilm_id(f.getFilm_id());
                int filmID = f2.getFilm_id();

                f2.setTitle(f.getTitle());
                f2.setRental_rate(f.getRental_rate());
                String rentalRate = f.getRental_rate();
                f2.setRental_duration(f.getRental_duration());
                FilmDao.addToRentalTable(customer_id, formatDate, filmID, rentalRate, Payment);
            }

            ses.setAttribute("filmsbought", filmsbought);

            //
            forward = CHECKOUT_RESULT;

            FilmDao.deleteFromCartAtStart(customer_id);
        } else if (action.equalsIgnoreCase("addwishlist"))
        {

            int customer_id = customerCurrent.getCustomer_Id();
            int film_id = Integer.parseInt(request.getParameter("film_id"));
            FilmDao.addWishlist(customer_id, film_id);
            FilmDao.viewWishlist(customer_id);

            Customer customer3 = new Customer();
            double Total = FilmDao.calculateTotal(customer_id);
            BigDecimal bd = new BigDecimal(Total).setScale(2, RoundingMode.HALF_EVEN);
            Total = bd.doubleValue();
            customer3.setUsername(customerCurrent.getUsername());
            customer3.setCustomer_Id(customerCurrent.getCustomer_Id());
            customer3.setTotal(Total);
            ArrayList<Customer> checkoutdetails1 = new ArrayList<Customer>();
            checkoutdetails1.add(customer3);

            ses.setAttribute("checkoutdetails", checkoutdetails1);
            ses.setAttribute("wishlistfilms", FilmDao.getWishlistDetails());
            forward = WISHLIST;

        } else if (action.equalsIgnoreCase("deletewishlist"))
        {

            int film_id = Integer.parseInt(request.getParameter("film_id"));
            int customer_id = customerCurrent.getCustomer_Id();
            FilmDao.deleteWish(customer_id, film_id);
            FilmDao.viewWishlist(customer_id);
            ses.setAttribute("wishlistfilms", FilmDao.getWishlistDetails());
            forward = WISHLIST;

        } else if (action.equalsIgnoreCase("viewwishlist"))
        {

            int customer_id = customerCurrent.getCustomer_Id();
            FilmDao.viewWishlist(customer_id);
            request.setAttribute("wishlistfilms", FilmDao.getWishlistDetails());
            forward = WISHLIST;

        } else if (action.equalsIgnoreCase("makeareturn"))
        {

            int customer_id = customerCurrent.getCustomer_Id();

            ses.setAttribute("Username", customerCurrent.getUsername());
            ses.setAttribute("Customer_Id", customer_id);
            FilmDao.getRentedFilms(customer_id);
            ses.setAttribute("rentedfilms", FilmDao.getRentedFilms());
            forward = RETURN;

        } else if (action.equalsIgnoreCase("return"))
        {

            int film_id = Integer.parseInt(request.getParameter("film_id")); //getting ID of film to return
            int customer_id = customerCurrent.getCustomer_Id();
            String Username = customerCurrent.getUsername();

            Film returnFilm = new Film();
            Film returnFilm2 = new Film();
            returnFilm = FilmDao.getFilmInformation(film_id); //title, duration, rate
            returnFilm2 = FilmDao.getFilmDateRented(film_id, customer_id); //setting date rented
            returnFilm2.setFilm_id(returnFilm.getFilm_id());
            returnFilm2.setTitle(returnFilm.getTitle());
            returnFilm2.setRental_duration(returnFilm.getRental_duration());
            returnFilm2.setRental_rate(returnFilm.getRental_rate());

            String dateRented = returnFilm2.getRental_date();
            double rental_rate = Double.parseDouble(returnFilm2.getRental_rate());
            double amountPaid = 0.0;
            String filmTitle = returnFilm2.getTitle();

            amountPaid = FilmDao.compareDueDate(dateRented, customer_id, rental_rate);
            //update transaction table
            FilmDao.addToTransactions(dateRented, film_id, customer_id, amountPaid);
            //delete rented movie from rental where customer and film id = ?
            FilmDao.deleteFromRental(customer_id, film_id);

            FilmDao.getReturnedFilms(customer_id, film_id);

            ses.setAttribute("Username", Username);
            ses.setAttribute("returnedfilms", FilmDao.getReturnedFilmsList());
            forward = RETURN_RESULTS;

        } else if (action.equalsIgnoreCase("rentalhistory"))
        {

            int customer_id = customerCurrent.getCustomer_Id();
            FilmDao.getRentalHistory(customer_id);

            ses.setAttribute("rentalhistory", FilmDao.getRentalHistoryList());

            forward = RENTAL_HISTORY;

        } else
        {
            forward = CUST_LOGIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession ses = request.getSession(true);
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();

        if (action.equalsIgnoreCase("login"))
        {

            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");
            customerCurrent.setUsername(Username);
            customerCurrent.setPassword(Password);
            int customer_id = 0;

            if (ValidateLogin.checkCustomer(Username, Password))
            {

                Customer customer1 = new Customer();
                customer1 = ValidateLogin.searchCustomer(Username, Password);

                customer_id = customer1.getCustomer_Id();

                customerCurrent.setCustomer_Id(customer_id);
                customerCurrent.setUsername(customer1.getUsername());
                customerCurrent.setPassword(customer1.getPassword());
                customerCurrent.setCustomer_Pref(customer1.getCustomer_Pref());
                customerCurrent.setPayment(customer1.getPayment());
                customerCurrent.setEmail(customer1.getEmail());

                String Payment = customerCurrent.getPayment();
                String message = "Login!";
                ses.setAttribute("message", message);
                ses.setAttribute("Username", Username);
                ses.setAttribute("Customer_Id", customer_id);
                ses.setAttribute("Payment", Payment);
                FilmDao.deleteFromCartAtStart(customer_id);
                RequestDispatcher rs = request.getRequestDispatcher(BROWSE);
                rs.forward(request, response);

            } else
            {
                String message = "Username or Password is Incorrect!";
                ses.setAttribute("message", message);
                RequestDispatcher rs = request.getRequestDispatcher(CUST_LOGIN);
                rs.include(request, response);
            }

        } else if (action.equalsIgnoreCase("createCust"))
        {

            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");
            String Customer_Pref = request.getParameter("Customer_Pref");
            String Payment = request.getParameter("Payment");
            String Email = request.getParameter("Email");

            customerCurrent.setUsername(Username);
            customerCurrent.setPassword(Password);
            customerCurrent.setCustomer_Pref(Customer_Pref);
            customerCurrent.setPayment(Payment);
            customerCurrent.setEmail(Email);

            if (Username != null && Password != null && Customer_Pref != null
                    && Payment != null && Email != null)
            {

                dao.addCustomer(customerCurrent);
                Customer newCust = new Customer();
                newCust = dao.getCustomerID(Username, Password);
                int customer_id = newCust.getCustomer_Id();
                customerCurrent.setCustomer_Id(customer_id);
                RequestDispatcher view = request.getRequestDispatcher(BROWSE);
                ses.setAttribute("Username", Username);
                ses.setAttribute("Customer_Id", customer_id);
                ses.setAttribute("Payment", Payment);
                view.forward(request, response);
            } else if (action.equalsIgnoreCase("return"))
            {

            } else
            {

                RequestDispatcher view = request.getRequestDispatcher(CREATE_CUSTOMER);
                view.forward(request, response);
            }

        }

    }

}
