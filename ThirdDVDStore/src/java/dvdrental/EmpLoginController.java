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
import javax.servlet.http.HttpSession;

/**
 *
 * @author mrwhi
 */
@WebServlet(name = "EmpLoginController", urlPatterns = {"/EmpLoginController"})
public class EmpLoginController extends HttpServlet {

    private static String EMP_LOGIN = "/EmployeeLogin.jsp";
    private static String MENU = "/EmployeeMenu.jsp";
    private static String CREATE_CUSTOMER = "/EmployeeCreate.jsp";

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession ses = request.getSession(true);
        
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        
        if(ValidateLogin.checkEmployee(Username, Password))
        { 
            RequestDispatcher rs = request.getRequestDispatcher(MENU);
            rs.forward(request, response);
        }
        else
        {
           String message = "Username or Password is incorrect!";
           ses.setAttribute("message", message);
           RequestDispatcher rs = request.getRequestDispatcher(EMP_LOGIN);
           rs.include(request, response);
        }
    }  
}
