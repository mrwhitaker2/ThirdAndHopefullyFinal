<%-- 
    Document   : CustomerLogin
    Created on : Apr 10, 2017, 7:33:24 PM
    Author     : mrwhi
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Create</title>
    </head>
    <body>
        <h1>Welcome! </h1>

        <form method="POST" action='CustomerController' name="frmAddCustomer"> 
            Username : <input
                type="text" required  name="Username"
                value="<c:out value="${customer.Username}" />" /> <br /> 
            Password : <input
                type="password" required  name="Password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                value="<c:out value="${customer.Password}" />" /> <br /> 
            Customer Movie Preference : <input
                type="text" required  name="Customer_Pref"
                value="<c:out value="${customer.Customer_Pref}" />" /> <br /> 
            Payment Method : <input
                type="text" required  name="Payment"
                value="<c:out value="${customer.Payment}" />" /> <br /> 
            Email : <input
                type="email" required  name="Email"
                value="<c:out value="${customer.Email}" />" /> <br /> 
            <br /> <input
                type="submit" value="Submit" />
        </form>

        <p><a href="CustomerController?action=browse">Browse Movies</a></p>
    </body>
</html>
