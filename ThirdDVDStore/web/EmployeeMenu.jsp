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
        <style>
            * {
                margin:0;
                padding:0;
                font-family: 'Source Sans Pro', sans-serif;
            }
            body {
                background:url("Styling/Photos/JalenHurts.jpeg") no-repeat center center fixed; 
                background-size:     cover;                      /* <------ */
                background-repeat:   no-repeat;
                background-position: center center;
            }
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
            .menu {
                position:relative;
                opacity: .8;
                width:40%;
                height:35%;
                margin:10% auto;
                text-align:center;
                background:#ecf0f1;
                padding:40px;
                -webkit-border-radius:20px 0 0 0;
                -moz-border-radius:20px 0 0 0;
                border-radius:20px 0 0 0;
                -webkit-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
                -moz-box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
                box-shadow: 0px 1px 0px #ad392d, inset 0px 1px 0px white;
                box-shadow: 20px 20px 20px;
            }
            .menu:hover
            {  
                opacity: 1.0;           
            }
            p,h1 {
                font-family: 'Source Sans Pro', sans-serif;
                font-size:2em;
                font-weight:300;
                margin: auto;
                margin-bottom:auto;
                color:#7f8c8d;
                text-shadow:1px 1px 0px white;
                text-align:center;
            }h1{
                color:black;
                text-decoration:underline;
            }
            input,select {
                display:block;
                width:90%;
                padding:14px;
                -webkit-border-radius:6px;
                -moz-border-radius:6px;
                border-radius:6px;
                border:0;
                margin-bottom:12px;
                color:#7f8c8d;
                font-weight:600;
                font-size:16px;
                align-content: center;
            }

            input:focus {
                background:#fafafa;
            }


            li {
                position:absolute;
                right:40px;
                bottom:62px;
                list-style:none;
            }
        </style>
        <title>Employee Menu</title>
    </head>
    <body>
        <div class="topnav" id="myTopnav" method="POST" action='EmployeeController' name="frmEmployee">
            <a href="EmployeeController?action=movieinventoryinfo">Checkouts, Sales, and Revenues</a>
            <a href="EmployeeController?action=avlinventory">Available Inventory</a>
            <a href="EmployeeController?action=bestandworstsellers">Best and worst sellers</a>
            <a href="EmployeeController?action=movienotsold">Not sold last year</a>
        </div>

        <div class="menu" id="myMenu">
            <form method="POST" action='CustomerController' name="frmCustomer"> 
                <p><a href="CustomerController?action=viewcustomers">Customer Profiles</a></p>
            </form>
            <!--
            <form method="POST" action='EmployeeController' name="frmEmployee"> 
                <p><a href="EmployeeController?action=movieinventoryinfo">Movie Checkouts and associated sales and revenue</a></p>
                <p><a href="EmployeeController?action=avlinventory">Available Inventory</a></p>            
                <p><a href="EmployeeController?action=bestandworstsellers">Best and worst sellers</a></p>
                <p><a href="EmployeeController?action=movienotsold">Not sold last year</a></p>
            </form>
            -->
        </div>
    </body>
</html>
