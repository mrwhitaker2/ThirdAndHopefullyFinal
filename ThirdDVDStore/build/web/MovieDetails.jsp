<%-- 
    Document   : moviedetails
    Created on : Apr 14, 2017, 4:56:35 PM
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
        
        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Release Year</th>
                    <th>Rental Duration</th>
                    <th>Rental Rate</th>
                    <th>Length</th>
                    <th>Rating</th>
                    <th>Special Features</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${filmdetails}" var="film">
                    <tr>
                        <td><c:out value="${film.film_id}" /></td>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        <td><c:out value="${film.release_year}" /></td>
                        <td><c:out value="${film.rental_duration}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.length}" /></td>
                        <td><c:out value="${film.rating}" /></td>
                        <td><c:out value="${film.special_features}" /></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
        
        
    </body>
</html>
