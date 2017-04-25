<%-- 
    Document   : CustomerLogin
    Created on : Apr 10, 2017, 8:04:24 PM
    Author     : mrwhi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CustomerLogin.css">
        <title>Customer Login</title>

    </head>
    <body>
        <form method="post" action="CustLoginController?action=login">
            <h1>Customer Login!</h1>
            <input type="text" value="<c:out value="${customer.Username}" />" name="Username" placeholder="Username"/><br/>
            <input 
                type="password" 
                placeholder="Password"
                value="<c:out value="${customer.Password}" />"
                name="Password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/><br/>
            <input type="submit" value="login" /><br>
            <p><a href="CustomerController?action=custcreate">Create an Account</a></p>
        </form>


    </body>
</html>
