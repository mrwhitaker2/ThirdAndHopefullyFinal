<%-- 
    Document   : CustomerBrowse
    Created on : Apr 10, 2017, 7:39:10 PM
    Author     : mrwhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/CustomerBrowse.css">
        <title>Customer Browse</title>
        <script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#genre').hide();
                $('#actor').hide();
                $('#store').hide();
                $('#criteria').change(function () {
                    if ($('#criteria option:selected').text() == "Genre") {
                        $('#genre').show();
                        $('#actor').hide();
                        $('#store').hide();
                    } else if ($('#criteria option:selected').text() == "Actor") {
                        $('#actor').show();
                        $('#genre').hide();
                        $('#store').hide();
                    } else if ($('#criteria option:selected').text() == "Store") {
                        $('#store').show();
                        $('#genre').hide();
                        $('#actor').hide();
                    }
                });
            });
        </script>
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
        </style>
    </head>

    <body>
        <div class="topnav" id="myTopnav">
            <a href="CustomerController?action=browse">Search Page</a>
            <a href="CustomerController?action=viewcart">View Shopping Cart</a>
            <a href="CustomerController?action=makeareturn">Return a Movie</a>
            <a href="CustomerController?action=viewwishlist">View Wishlist</a>
            <a href="CustomerController?action=rentalhistory">Rental History</a>
        </div>

        <div>
            <form method="post" action="SearchController?action=search">
                <h1>Hello, <%=session.getAttribute("Username")%> </h1><br/>
                <h2>Your Customer ID is: <%=session.getAttribute("Customer_Id")%> </h2>
                <h2>Your Payment Method is: <%=session.getAttribute("Payment")%> </h2><br/>
                <select name="criteria" id="criteria">
                    <option value="selection">Search by...</option>
                    <option value="Genre">Genre</option>
                    <option value="Actor">Actor</option>
                    <option value="Store">Store</option>
                </select>

                <select name="genrefield" id="genre">
                    <option value="Action">Action</option>
                    <option value="Animation">Animation</option>
                    <option value="Children">Children</option>
                    <option value="Classics">Classics</option>
                    <option value="Comedy">Comedy</option>
                    <option value="Documentary">Documentary</option>
                    <option value="Drama">Drama</option>
                    <option value="Family">Family</option>
                    <option value="Foreign">Foreign</option>
                    <option value="Games">Games</option>
                    <option value="Horror">Horror</option>
                    <option value="Music">Music</option>
                    <option value="New">New</option>
                    <option value="Sci-Fi">Sci-Fi</option>
                    <option value="Sports">Sports</option>
                    <option value="Travel">Travel</option>
                </select>

                <select name="actorfield" id="actor">
                    <option value="Akroyd">Akroyd</option>
                    <option value="Astaire">Astaire</option>
                    <option value="Bailey">Bailey</option>
                    <option value="Barrymore">Barrymore</option>
                    <option value="Bergen">Bergen</option>
                    <option value="Berry">Berry</option>
                    <option value="Bloom">Bloom</option>
                    <option value="Bolger">Bolger</option>
                    <option value="Bridges">Bridges</option>
                    <option value="Brody">Brody</option>
                    <option value="Cage">Cage</option>
                    <option value="Chaplin">Chaplin</option>
                    <option value="Chase">Chase</option>
                    <option value="Costner">Costner</option>
                    <option value="Crawford">Crawford</option>
                    <option value="Cronyn">Cronyn</option>
                    <option value="Cruise">Cruise</option>
                    <option value="Cruz">Cruz</option>
                    <option value="Damon">Damon</option>
                    <option value="Davis">Davis</option>
                    <option value="Day-Lewis">Day-Lewis</option>
                    <option value="Dean">Dean</option>
                    <option value="Degeneres">Degeneres</option>
                    <option value="Dench">Dench</option>
                    <option value="Depp">Depp</option>
                    <option value="Dukakis">Dukakis</option>
                    <option value="Fawcett">Fawcett</option>
                    <option value="Gable">Gable</option>
                    <option value="Goldberg">Goldberg</option>
                    <option value="Grant">Grant</option>
                    <option value="Guiness">Guiness</option>
                    <option value="Hackman">Hackman</option>
                    <option value="Harris">Harris</option>
                    <option value="Hawke">Hawke</option>
                    <option value="Hoffman">Hoffman</option>
                    <option value="Hopkins">Hopkins</option>
                    <option value="Hudson">Hudson</option>
                    <option value="Hunt">Hunt</option>
                    <option value="Johansson">Johansson</option>
                    <option value="Jolie">Jolie</option>
                    <option value="Jovovich">Jovovich</option>
                    <option value="Keitel">Keitel</option>
                    <option value="Kilmer">Kilmer</option>
                    <option value="Lollobrigida">Lollobrigida</option>
                    <option value="Marx">Marx</option>
                    <option value="Mcconaughey">Mcconaughey</option>
                    <option value="Mckellen">Mckellen</option>
                    <option value="Mcqueen">Mcqueen</option>
                    <option value="Miranda">Miranda</option>
                    <option value="Mostel">Mostel</option>
                    <option value="Neeson">Neeson</option>
                    <option value="Nicholson">Nicholson</option>
                    <option value="Olivier">Olivier</option>
                    <option value="Paltrow">Paltrow</option>
                    <option value="Peck">Peck</option>
                    <option value="Penn">Penn</option>
                    <option value="Pesci">Pesci</option>
                    <option value="Phoenix">Phoenix</option>
                    <option value="Pinkett">Pinkett</option>
                    <option value="Pitt">Pitt</option>
                    <option value="Posey">Posey</option>
                    <option value="Presley">Presley</option>
                    <option value="Sinatra">Sinatra</option>
                    <option value="Sobieski">Sobieski</option>
                    <option value="Stallone">Stallone</option>
                    <option value="Streep">Streep</option>
                    <option value="Swank">Swank</option>
                    <option value="Tandy">Tandy</option>
                    <option value="Tautou">Tautou</option>
                    <option value="Temple">Temple</option>
                    <option value="Torn">Torn</option>
                    <option value="Tracy">Tracy</option>
                    <option value="Voight">Voight</option>
                    <option value="Wahlberg">Wahlberg</option>
                    <option value="Wayne">Wayne</option>
                    <option value="Williams">Williams</option>
                    <option value="Willis">Willis</option>
                    <option value="Winslet">Winslet</option>
                </select>

                <select name="storefield" id="store">
                    <option value="1">1 - Alberta District</option>
                    <option value="2">2 - QLD District</option>
                </select>

                <input type="submit" value="Search" />
        </div> 
    </form>
</body>
</html>
