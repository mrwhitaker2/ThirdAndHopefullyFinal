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
   
    private EmployeeDAO dao;

   
    public EmployeeController() {
        super();
        dao = new EmployeeDAO();
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
          else if (action.equalsIgnoreCase("empcreate")) {
            forward = CREATE_EMP;
      } 
        else {
            forward = CREATE_CUSTOMER;
        }
        
        

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setFirst_name(request.getParameter("first_name"));
        employee.setLast_name(request.getParameter("last_name"));
        employee.setAddress_id(request.getParameter("address_id"));
        employee.setEmail(request.getParameter("email"));
        employee.setStore_id(request.getParameter("store_id"));
        employee.setActive(true);
        employee.setUsername(request.getParameter("username"));
        employee.setPassword(request.getParameter("password"));
        employee.setLast_update("04/15/2017");
        employee.setPicture("null");

       
        dao.addEmployee(employee);
        
        RequestDispatcher view = request.getRequestDispatcher(BROWSE);
       // request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }
    

}