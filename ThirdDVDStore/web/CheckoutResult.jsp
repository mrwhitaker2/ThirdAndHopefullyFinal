<%-- 
    Document   : CheckoutResult
    Created on : Apr 25, 2017, 1:51:03 PM
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

        <h2>The films you have checked out are listed below: </h2>

        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Rate</th>
                    <th>Rental Duration</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${filmsbought}" var="film">
                    <tr>
                        <td><c:out value="${film.film_id}" /></td>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rental_duration}" /></td>
                    </tr>
                </c:forEach>
            </tbody>

            <p><a href="CustomerController?action=browse">Back to Browse</a></p>

</html>
