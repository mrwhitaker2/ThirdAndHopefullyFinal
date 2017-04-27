<%-- 
    Document   : MovieBestAndWorstSellers
    Created on : Apr 11, 2017, 2:37:49 PM
    Author     : wsullivan16
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Best and Worst Sellers</title>
    </head>
    <body>
        <h1>Best and Worst Sellers</h1>
        <form method="POST" action='EmployeeController' name="frmEmployee"> 
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
            <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Sales</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${salesObjs}" var="salesObj">
                    <tr>
                        <td><c:out value="${salesObj.title}" /></td>
                        <td><c:out value="${salesObj.sales}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </form>
    </body>
</html>
