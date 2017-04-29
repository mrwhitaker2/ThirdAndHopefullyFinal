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
        <title>JSP Page</title>
    </head>
    <body>
        
       
        <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Date Rented</th>
                    <th>Amount Paid</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${rentalhistory}" var="transaction">
                    <tr>
                        <td><c:out value="${transaction.getFilm_Id()}" /></td>
                        <td><c:out value="${transaction.getTitle()}" /></td>
                        <td><c:out value="${transaction.getDate_Rented()}" /></td>
                        <td><c:out value="${transaction.getAmount()}" /></td>                  
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        
            <p><a href="CustomerController?action=browse">Back to Browse</a></p>
                     
    </body>
</html>

