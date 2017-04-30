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
        <link rel="stylesheet" type="text/css" href="Styling/CustomerLogin.css">
        <title>Customer Login</title>
    </head>
    
    <body>
    
        <form method="post" action="CustomerController?action=login">
            <h1><%=session.getAttribute("message")%></h1><br/>
            <input type="text"
                   value="<c:out value="${customer.Username}" />" 
                   name="Username"
                   placeholder="Username"/><br/>
            <input 
                type="password" 
                value="<c:out value="${customer.Password}" />"
                name="Password"
                Placeholder="Password"/><br/>
            <input type="submit" value="login" /><br/>
            <p><a href="CustomerController?action=custcreate">Create an Account</a></p>
        </form>  
    </body>
</html>
