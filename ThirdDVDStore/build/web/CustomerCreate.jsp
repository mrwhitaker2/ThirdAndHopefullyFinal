<%-- 
    Document   : CustomerLogin
    Created on : Apr 10, 2017, 7:33:24 PM
    Author     : mrwhi
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Styling/CustomerCreate.css">
        <title>Customer Creation</title>
    </head>
    <body>        
        <form method="POST" action='CustomerController?action=createCust' name="frmAddCustomer">
            <h1>Customer Creation</h1>
            <input
                type="text" 
                required 
                placeholder="Username"
                name="Username"
                value="<c:out value="${customer.Username}" />" /> <br /> 
            <input
                type="password"
                required
                placeholder="password"
                name="Password"
                pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                value="<c:out value="${customer.Password}" />" /> <br /> 
            <select
                name="Customer_Pref"
                required
                title="Please select your favorite movie genre"
                value="<c:out value="${customer.Customer_Pref}" />" />
            <br />
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

        </select><br> 
        <select  
            required
            placeholder="Customer Payment Preference"
            name="Payment" 
            title="Please select your preferred method of payment"
            value="<c:out value="${customer.Customer_Pref}" />" /> <br />>
        <option value="debit">Debit</option>
        <option value="credit">Credit</option>
        <option value="bitcoin">Bitcoin</option>
    </select><br/>          
    <input
        type="email"
        placeholder="Email"
        required
        name="Email"
        value="<c:out value="${customer.Email}" />" /> <br /> 
    <br /> 
    <input type="submit" value="Submit" />
</form>

<p><a href="CustomerController?action=browse">Browse Movies</a></p>
</body>
</html>
