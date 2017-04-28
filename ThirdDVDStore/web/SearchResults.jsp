

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/SearchResults.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Search Results</title>
    </head>

        <p><a href="CustomerController?action=browse">Back to search</a></p>
        <p><a href="CustomerController?action=viewcart">View Shopping Cart</a></p>

        <table border=1 id="tableID" class="w3-table-all w3-hoverable w3-centered w3-card w3-small">
            <thead>
                <tr class="w3-red">
                    <th>Title</th>
                    <th>Description</th>
                    <th>Rental Rate</th>
                    <th>Rating</th>
                    <th colspan=3>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rating}" /></td>
                        
                        <td><a href="CustomerController?action=addcart&film_id=<c:out value="${film.film_id}"/>">Add to Cart</a></td>
                        <td><a href="CustomerController?action=addwishlist&film_id=<c:out value="${film.film_id}"/>">Add to Wishlist</a></td>
                        <td><a href="CustomerController?action=viewdetails&film_id=<c:out value="${film.film_id}"/>">View Movie Details</a></td>
                   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
