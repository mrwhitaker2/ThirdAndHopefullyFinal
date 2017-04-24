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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome New Hire! </h1>
        
          <form method="POST" action='EmployeeController' name="frmAddEmployee"> 
            
             First Name: <input
                type="text" required  name="first_name"
                value="<c:out value="${employee.first_name}" />" /> <br />
             Last Name : <input
                type="text" required  name="last_name"
                value="<c:out value="${employee.last_name}" />" /> <br /> 
             Email: <input
                type="text" required  name="email"
                value="<c:out value="${employee.email}" />" /> <br />
            Username : <input
                type="text" required  name="username"
                value="<c:out value="${employee.username}" />" /> <br /> 
            Password : <input
                type="text" required   name="password"
                value="<c:out value="${employee.password}" />" /> <br /> 
           
            <br /> <input
                           type="submit" value="Submit" />
        </form>
            
            <p><a href="EmployeeController?action=menu">Employee Menu</a></p>
    </body>
</html>
