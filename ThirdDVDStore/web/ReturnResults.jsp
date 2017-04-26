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

        <h1>Hello, <%=session.getAttribute("Username")%> </h1>
        <h2>The films you have returned are listed below: </h2>

        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Date Rented</th>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Amount Charged to card on file</th>
                    
                </tr>
            </thead>
            <tbody >
            <c:forEach items="${returnedfilms}" var="transaction">
                <tr>
                <td><c:out value="${transaction.getDate_Rented()}" /></td>
                <td><c:out value="${transaction.getFilm_Id()}" /></td>
                <td><c:out value="${transaction.getTitle()}" /></td>
                <td><c:out value="${transaction.getAmount()}" /></td>
                </tr>
            </c:forEach>
        </tbody>



</html>

