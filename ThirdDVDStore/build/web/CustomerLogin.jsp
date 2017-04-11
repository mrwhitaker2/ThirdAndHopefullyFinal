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
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1> Login! </h1>
        
        <form method="post" action="CustLoginController?action=login">
        Username:<input type="text" value="<c:out value="${customer.Username}" />" name="Username" /><br/>
        Password:<input type="text" value="<c:out value="${customer.Password}" />"name="Password" /><br/>
        <input type="submit" value="login" />
        </form>

            <p><a href="CustomerController?action=custcreate">Create an Account</a></p>
    </body>
</html>
