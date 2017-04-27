<<<<<<< HEAD
<%-- 
    Document   : CustomerProfile
    Created on : Apr 11, 2017, 1:55:41 PM
    Author     : wsullivan16
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Styling/Welcome.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Profile</title>
    </head>
    <body>
        <h1>Customer Profile</h1>
         <form method="POST" action='EmployeeController' name="frmEmployee">
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
            <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Customer Preference</th>
                    <th>Payment</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td><c:out value="${customer.getCustomer_Id()}" /></td>
                        <td><c:out value="${customer.getUsername()}" /></td>
                        <td><c:out value="${customer.getPassword()}" /></td>
                        <td><c:out value="${customer.getCustomer_Pref()}"/></td>
                        <td><c:out value="${customer.getPayment()}" /></td>
                        <td><c:out value="${customer.getEmail()}" /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
         </form>
    </body>
</html>

=======
<%-- 
    Document   : CustomerProfile
    Created on : Apr 11, 2017, 1:55:41 PM
    Author     : wsullivan16
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Profile</title>
    </head>
    <body>
        <h1>Customer Profile</h1>
         <form method="POST" action='EmployeeController' name="frmEmployee">
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
            <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Customer Preference</th>
                    <th>Payment</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td><c:out value="${customer.getCustomer_Id()}" /></td>
                        <td><c:out value="${customer.getUsername()}" /></td>
                        <td><c:out value="${customer.getPassword()}" /></td>
                        <td><c:out value="${customer.getCustomer_Pref()}"/></td>
                        <td><c:out value="${customer.getPayment()}" /></td>
                        <td><c:out value="${customer.getEmail()}" /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
         </form>
    </body>
</html>

>>>>>>> refs/remotes/origin/master
