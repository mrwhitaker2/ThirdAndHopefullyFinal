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
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1> Employee Login! </h1>
        
         <form method="POST" action='CustomerController' name="frmCustomer"> 
            Username : <input
                type="text" required  name="Username"
                value="<c:out value="${employee.username}" />" /> <br /> 
            Password : <input
                type="text" required  name="Password"
                value="<c:out value="${employee.password}" />" /> <br /> 
            <input
                           type="submit" value="Submit" />
            
            <p><a href="EmployeeController?action=empcreate">Create an Employee Account</a></p>
    </body>
</html>
