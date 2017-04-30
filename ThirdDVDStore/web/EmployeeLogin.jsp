<%-- 
   Document   : EmployeeLogin
   Created on : Apr 10, 2017, 8:33:21 PM
   Author     : mrwhi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/EmployeeLogin.css">
        <title>Employee Login</title>
    </head>
    <body>
        <form method="post" action="EmpLoginController?action=login">
            <h1> Employee Login! </h1><br/>
            <input
                placeholder="Username"
                type="text" 
                value="<c:out value="${employee.Username}" />" 
                name="Username" /><br/>
            <input 
                type="password"
                placeholder="Password"
                value="<c:out value="${employee.Password}" />" 
                name="Password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/><br/>
            <%
                ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
                out.print(c.createRecaptchaHtml(null, null));
            %>

            <input type="submit" value="login" /><br/>
            <p><a href="EmployeeController?action=empcreate">Create an Employee Account</a></p>
        </form>        
    </body>
</html>
