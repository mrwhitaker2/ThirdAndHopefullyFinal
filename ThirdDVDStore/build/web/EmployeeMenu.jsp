<%-- 
    Document   : EmployeeMenu
    Created on : Apr 10, 2017, 9:44:11 PM
    Author     : mrwhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/EmployeeMenu.css">
        <title>Employee Menu</title>
    </head>
    <body>
        <div>
            <h1>Employee Menu</h1><br/>

            <form method="POST" action='CustomerController' name="frmCustomer"> 
                <p><a href="CustomerController?action=viewcustomers">Customer Profiles</a></p>
            </form>
            <form method="POST" action='EmployeeController' name="frmEmployee"> 
                <p><a href="EmployeeController?action=movieinventoryinfo">Movie Checkouts and associated sales and revenue</a></p>
                <p><a href="EmployeeController?action=avlinventory">Available Inventory</a></p>            
                <p><a href="EmployeeController?action=bestandworstsellers">Best and worst sellers</a></p>
                <p><a href="EmployeeController?action=movienotsold">Not sold last year</a></p>
            </form>
        </div>
    </body>
</html>
