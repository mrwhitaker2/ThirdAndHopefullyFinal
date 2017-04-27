<%-- 
    Document   : Return
    Created on : Apr 25, 2017, 9:21:57 PM
    Author     : mrwhi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return</title>
    </head>
    <body>
        <h1>Hello, <%=session.getAttribute("Username")%> </h1>
        <h2>Your Customer ID is: <%=session.getAttribute("Customer_Id")%> </h2>

        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Rate</th>
                    <th>Rental Duration</th>
                    <th>Date Rented</th>
                    <th colspan=1>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${rentedfilms}" var="film">
                    <tr>
                        <td><c:out value="${film.film_id}" /></td>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rental_duration}" /></td>
                        <td><c:out value="${film.rental_date}" /></td>
                        <td><a href="CustomerController?action=return&film_id=<c:out value="${film.film_id}"/>">Return</a></td>
                    </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
