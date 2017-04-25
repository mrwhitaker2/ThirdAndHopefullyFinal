/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String WELCOME = "/welcome.jsp";
    private static String CREATE_CUSTOMER = "/CustomerCreate.jsp";
    private static String CUST_LOGIN = "/CustomerLogin.jsp";
    private static String EMP_LOGIN = "/EmployeeLogin.jsp";
    private static String BROWSE = "/CustomerBrowse.jsp";
    private static String CREATE_EMP = "/EmployeeCreate.jsp";
    private static String MENU = "/EmployeeMenu.jsp";
    private static String MOVIE_INVENTORY_INFO = "/MovieInventoryInfo.jsp";
    private static String AVAILABLE_MOVIE_INVENTORY = "/MovieAvailableInventory.jsp";
    private static String BEST_AND_WORST_SELLERS = "MovieBestAndWorstSellers.jsp";
    private static String NOT_SOLD = "MovieNotSold.jsp";

    private EmployeeDAO dao;
    private FilmDAO filmDAO;

    public EmployeeController() {
        super();
        dao = new EmployeeDAO();
        filmDAO = new FilmDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("custlogin")) {
            forward = CUST_LOGIN;
        } else if (action.equalsIgnoreCase("welcome")) {
            forward = WELCOME;
        } else if (action.equalsIgnoreCase("browse")) {
            forward = BROWSE;
        } else if (action.equalsIgnoreCase("emplogin")) {
            forward = EMP_LOGIN;
        } else if (action.equalsIgnoreCase("empcreate")) {
            forward = CREATE_EMP;
        } else if (action.equalsIgnoreCase("movieinventoryinfo")) {
            forward = MOVIE_INVENTORY_INFO;
            request.setAttribute("salesObjs", filmDAO.getMovieCheckoutsReport());
        } else if (action.equalsIgnoreCase("avlinventory")) {
            filmDAO.getRentalNoBS();
            forward = AVAILABLE_MOVIE_INVENTORY;
            request.setAttribute("films", filmDAO.getInventory());
        } else if (action.equalsIgnoreCase("bestandworstsellers")) {
            forward = BEST_AND_WORST_SELLERS;
        } else if (action.equalsIgnoreCase("movienotsold")) {
            forward = NOT_SOLD;
        } else {
            forward = MENU;
        }

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setFirst_name(request.getParameter("first_name"));
        employee.setLast_name(request.getParameter("last_name"));
        employee.setEmail(request.getParameter("email"));
        employee.setUsername(request.getParameter("username"));
        employee.setPassword(request.getParameter("password"));

        dao.addEmployee(employee);

        RequestDispatcher view = request.getRequestDispatcher(EMP_LOGIN);
        // request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }

}
