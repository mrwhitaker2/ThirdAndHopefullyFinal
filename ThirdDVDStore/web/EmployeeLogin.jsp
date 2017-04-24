<%-- 
   Document   : EmployeeLogin
   Created on : Apr 10, 2017, 8:33:21 PM
   Author     : mrwhi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Login</title>
    </head>
    <body>

        <h1> Employee Login! </h1>

        <form method="post" action="EmpLoginController?action=login">
            Username:<input type="text" value="<c:out value="${employee.Username}" />" name="Username" /><br/>
            Password:<input 
                type="password" value="<c:out value="${employee.Password}" />" name="Password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/><br/>
            <input type="submit" value="login" />
        </form>

        <p><a href="EmployeeController?action=empcreate">Create an Employee Account</a></p>
    </body>
</html>
