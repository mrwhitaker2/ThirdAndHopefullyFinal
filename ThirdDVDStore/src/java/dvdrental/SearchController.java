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
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static String RESULTS = "/SearchResults.jsp";
    private static String BROWSE = "/CustomerBrowse.jsp";
    List<Film> films = new ArrayList<Film>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String criteria = request.getParameter("criteria");
        String field = request.getParameter("field");

        if (criteria.equalsIgnoreCase("Genre")) {
            
            FilmDAO.searchGenre(field);
            request.setAttribute("films", FilmDAO.searchGenre(field));
            RequestDispatcher rs = request.getRequestDispatcher(RESULTS);
            rs.forward(request, response);
           
                // RequestDispatcher rs = request.getRequestDispatcher(BROWSE);
                 //rs.forward(request, response);
        

        } else if (criteria.equalsIgnoreCase("Actor")) {

            FilmDAO.searchActor(field);
            RequestDispatcher rs = request.getRequestDispatcher(RESULTS);
            rs.forward(request, response);
        } else if (criteria.equalsIgnoreCase("Store")) {
            //FilmDAO.searchStore(field);
            RequestDispatcher rs = request.getRequestDispatcher(RESULTS);
            rs.forward(request, response);
        } else {
            out.println("Your search did not provide any results.");
            RequestDispatcher rs = request.getRequestDispatcher(BROWSE);
            rs.include(request, response);
        }
    }

}
