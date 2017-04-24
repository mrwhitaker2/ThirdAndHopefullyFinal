<%-- 
    Document   : welcome
    Created on : Apr 10, 2017, 8:28:23 PM
    Author     : mrwhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Page1CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Crimson Video Store!</h1>
        <div class="container">
            <p><a class="customerLink" href="CustomerController?action=custlogin">Customers Click Here!</a></p>
            <p><a class="employeeLink" href="CustomerController?action=emplogin">Employees Click Here!</a></p>
        </div>
    </body>
</html>
