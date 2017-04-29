<%-- 
    Document   : CustomerProfile
    Created on : Apr 11, 2017, 1:55:41 PM
    Author     : wsullivan16
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>Customer Profile</title>
        <style>
            .topnav {
                background-color: #333;
                overflow: hidden;
                align-content: center;
            }

            /* Style the links inside the navigation bar */
            .topnav a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            /* Change the color of links on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Add a color to the active/current link */
            .topnav a.active {
                background-color: #4CAF50;
                color: white;
            }
            .button-link {
                padding: 10px 15px;
                background:#7f8c8d;
                color: #FFF;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                border-radius: 4px;
                border: solid 1px white;
                text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.4);
                -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);
                -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);
                box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.4), 0 1px 1px rgba(0, 0, 0, 0.2);
                -webkit-transition-duration: 0.2s;
                -moz-transition-duration: 0.2s;
                transition-duration: 0.2s;
            }
            .button-link:hover, .button-link:focus {
                background: #356094;
                border: solid 1px #2A4E77;
                text-decoration: none;
            }

            .button-link:active {
                -webkit-box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);
                -moz-box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);
                box-shadow: inset 0 1px 4px rgba(0, 0, 0, 0.6);
                background: #2E5481;
                border: solid 1px #203E5F;
            }

        </style>
    </head>
    <body>
        <div class="topnav" id="myTopnav" method="POST" action='EmployeeController' name="frmEmployee">
            <a href="EmployeeController?action=movieinventoryinfo">Checkouts, Sales, and Revenues</a>
            <a href="EmployeeController?action=avlinventory">Available Inventory</a>
            <a href="EmployeeController?action=bestandworstsellers">Best and worst sellers</a>
            <a href="EmployeeController?action=movienotsold">Not sold last year</a>
        </div>
        <form method="POST" action='EmployeeController' name="frmEmployee">
            <table border=1 id="tableID" class="w3-table-all w3-hoverable w3-centered w3-card w3-small">
                <thead>
                    <tr class="w3-red">
                        <th>Customer ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Customer Preference</th>
                        <th>Payment</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach items="${customers}" var="customer">
                        <tr>
                            <td><c:out value="${customer.getCustomer_Id()}" /></td>
                            <td><c:out value="${customer.getUsername()}" /></td>
                            <td><c:out value="${customer.getPassword()}" /></td>
                            <td><c:out value="${customer.getCustomer_Pref()}"/></td>
                            <td><c:out value="${customer.getPayment()}" /></td>
                            <td><c:out value="${customer.getEmail()}" /></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>

