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
    <body>
<<<<<<< HEAD
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>

=======
         <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th colspan=3>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        
                        <td><a href="CustomerController?actionaddcart=&film_id=<c:out value="${film.film_id}"/>">Add to Cart</a></td>
                        <td><a href="CustomerController?action=addwishlist&film_id=<c:out value="${film.film_id}"/>">Add to Wishlist</a></td>
                        <td><a href="CustomerController?action=viewcart">View Cart</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
>>>>>>> refs/remotes/origin/master
    </body>
</html>
