<%-- 
    Document   : ShoppingCart
    Created on : Apr 11, 2017, 8:05:39 PM
    Author     : mrwhi
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist</title>
    </head>
    <body>
       
        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Rate</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${wishlistfilms}" var="film">
                    <tr>
                        <td><c:out value="${film.film_id}" /></td>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><a href="CustomerController?action=deletewishlist&film_id=<c:out value="${film.film_id}"/>">Remove</a></td>
                        <td><a href="CustomerController?action=addcart&film_id=<c:out value="${film.film_id}"/>">Add to Cart</a></td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
       
            
         
    </body>
</html>
