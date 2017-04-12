<%-- 
    Document   : SearchResults
    Created on : Apr 11, 2017, 3:36:38 PM
    Author     : mrwhi
--%>


<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table border=1 id="tableID">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${films}" var="film">
                    <tr>
                        <td><c:out value="${film.title}" /></td>
                        <td><c:out value="${film.description}" /></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
    </body>
</html>
