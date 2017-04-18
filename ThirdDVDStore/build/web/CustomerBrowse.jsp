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
        <title>JSP Page</title>
    </head>
    <body>

         <h1>Hello, <%=session.getAttribute("Username")%></h1>

             <form method="post" action="SearchController?action=search">
            <h2>Search your movie:</h2>  
               
                Search Category (Genre, Actor, Store): 
                <input type="text" name="criteria" /><br/>
                Search Field: <input type="text" name="field" /><br/>
                <input type="submit" value="Search" />
            
                
        </form>
                






    </body>
</html>
