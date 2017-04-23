<%-- 
    Document   : SearchResults
    Created on : Apr 11, 2017, 3:36:38 PM
    Author     : mrwhi
--%>


<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

        <p><a href="CustomerController?action=browse">Back to search</a></p>

        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Rental Rate</th>
                    <th>Rating</th>
                    <th colspan=4>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rating}" /></td>
                        
                        <td><a href="CustLoginController?action=addcart&film_id=<c:out value="${film.film_id}"/>">Add to Cart</a></td>
                        <td><a href="CustomerController?action=addwishlist&film_id=<c:out value="${film.film_id}"/>">Add to Wishlist</a></td>
                        <td><a href="CustomerController?action=viewcart">View Cart</a></td>
                        <td><a href="CustomerController?action=viewdetails&film_id=<c:out value="${film.film_id}"/>">View Movie Details</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
