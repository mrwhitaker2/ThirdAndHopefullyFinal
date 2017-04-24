<%-- 
    Document   : Available Inventory
    Created on : Apr 11, 2017, 2:20:21 PM
    Author     : wsullivan16
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Inventory</title>
    </head>
    <body>
        <h1>Avaliable Inventory</h1>
        
        <form method="POST" action='EmployeeController' name="frmEmployee"> 
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
              <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Rental Rate</th>
                    <th>Rating</th>
                    <th>In Stock</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rating}" /></td>
                        <td><c:out value="${film.inStock}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </form>
    </body>
</html>
