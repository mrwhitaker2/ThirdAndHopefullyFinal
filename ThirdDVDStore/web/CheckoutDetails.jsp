<%-- 
    Document   : CheckoutDetails
    Created on : Apr 23, 2017, 12:17:32 PM
    Author     : mrwhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form method="post" action="CustomerController?action=checkout"> 
        <body>
            <table border=1 id="tableID">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Customer ID</th>
                        <th>Total</th>
                        
                    </tr>
                </thead>
                <tbody >
                    <c:forEach items="${checkoutdetails}" var="customer">
                        <tr>
                            <td><c:out value="${customer.getUsername()}" /></td>
                            <td><c:out value="${customer.getCustomer_Id()}" /></td>
                            <td><c:out value="${customer.getTotal()}" /></td>

                        </tr>
                    </tbody>
                </c:forEach>

                Payment type:
                <select name="payment" id="payment">
                    <option value="selection">Select Payment...</option>
                    <option value="Credit">Credit</option>
                    <option value="Debit">Debit</option>
                </select> <br>

                Payment Amount: <input type="text" value="<c:out value="${customer.Payment_Amount}" />" name="Payment_Amount" /><br/>
                <input type="submit" value="Enter" />
    </form>

</body>
</html>
