<%-- 
    Document   : MovieInventoryInfo
    Created on : Apr 11, 2017, 2:01:27 PM
    Author     : wsullivan16
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Inventory Info</title>
    </head>
    <body>
        <h1>Move Inventory Info</h1>
        
        <form method="POST" action='EmployeeController' name="frmEmployee"> 
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
            <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Rental Rate</th>
                    <th>Times Rented</th>
                    <th>Sales</th>
                    <th>Revenue</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${salesObjs}" var="salesObj">
                    <tr>
                        <td><c:out value="${salesObj.title}" /></td>
                        <td><c:out value="${salesObj.rental_rate}" /></td>
                        <td><c:out value="${salesObj.times_rented}" /></td>
                        <td><c:out value="${salesObj.sales}" /></td>
                        <td><c:out value="${salesObj.revenue}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </form>
    </body>
</html>
