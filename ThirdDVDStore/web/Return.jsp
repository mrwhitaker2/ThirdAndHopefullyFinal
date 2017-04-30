<%-- 
    Document   : Return
    Created on : Apr 25, 2017, 9:21:57 PM
    Author     : mrwhi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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
        <title>Return</title>
    </head>
    <body>
        <div class="topnav" id="myTopnav">
            <a href="CustomerController?action=browse">Search Page</a>
            <a href="CustomerController?action=viewcart">View Shopping Cart</a>
            <a href="CustomerController?action=makeareturn">Return a Movie</a>
            <a href="CustomerController?action=viewwishlist">View Wishlist</a>
            <a href="CustomerController?action=rentalhistory">Rental History</a>
        </div>
        <h1>Hello, <%=session.getAttribute("Username")%> </h1>
        <h2>Your Customer ID is: <%=session.getAttribute("Customer_Id")%> </h2>

        <table border=1 id="tableID" class="w3-table-all w3-hoverable w3-centered w3-card w3-small">
            <thead>
                <tr class="w3-red">
                    <th>Film ID</th>
                    <th>Title</th>
                    <th>Rental Rate</th>
                    <th>Rental Duration</th>
                    <th>Date Rented</th>
                    <th colspan=1>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${rentedfilms}" var="film">
                    <tr>
                        <td><c:out value="${film.film_id}" /></td>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.rental_rate}" /></td>
                        <td><c:out value="${film.rental_duration}" /></td>
                        <td><c:out value="${film.rental_date}" /></td>
                        <td><a href="CustomerController?action=return&film_id=<c:out value="${film.film_id}"/>">Return</a></td>
                    </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
