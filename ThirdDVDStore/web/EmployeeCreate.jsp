<%-- 
    Document   : EmployeeCreate
    Created on : Apr 10, 2017, 9:19:24 PM
    Author     : mrwhi
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/EmployeeCreate.css">
        <title>Employee Create</title>
    </head>
    <body>
        <form method="POST" action='EmployeeController' name="frmAddEmployee"> 
            <h1>Welcome New Hire! </h1><br/>
            <input
                placeholder="First Name"
                type="text" required  name="first_name"
                value="<c:out value="${employee.first_name}" />" /> <br />
            <input
                placeholder="Last Name"
                type="text" required  name="last_name"
                value="<c:out value="${employee.last_name}" />" /> <br /> 
            <input
                placeholder ="Email"
                type="email" required  name="email"
                value="<c:out value="${employee.email}" />" /> <br />
            <input
                placeholder="Username"
                type="text" required  name="username"
                value="<c:out value="${employee.username}" />" /> <br /> 
            <input
                placeholder ="Password"
                type="password" required   name="password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                value="<c:out value="${employee.password}" />" /> <br /> 

            <br /> <input
                type="submit" value="Submit" />
        </form>
    </body>
</html>
