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
        <title>Search Results</title>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"
              <!-- Latest compiled and minified CSS -->
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>

    <p><a href="CustomerController?action=browse">Back to search</a></p>
    <p><a href="CustomerController?action=viewcart">View Shopping Cart</a></p>

    <table border=1 id="tableID" class="display">
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Rental Rate</th>
                <th>Rating</th>
                <th colspan="3">Actions</th>
            </tr>
        </thead>
        <tbody >
            <c:forEach items="${films}" var="film">
                <tr>
                    <td><c:out value="${film.title}" /></td>
                    <td><c:out value="${film.description}" /></td>
                    <td><c:out value="${film.rental_rate}" /></td>
                    <td><c:out value="${film.rating}" /></td>

<!--<td><a href="CustomerController?action=addcart&film_id=<c:out value="${film.film_id}"/>">Add to Cart</a></td>
<td><a href="CustomerController?action=addwishlist&film_id=<c:out value="${film.film_id}"/>">Add to Wishlist</a></td>
<td><a href="CustomerController?action=viewdetails&film_id=<c:out value="${film.film_id}"/>">View Movie Details</a></td>-->
                    <td><c:out value="${film.film_id}" /></td>
                    <td><c:out value="${film.film_id}" /></td>
                    <td><c:out value="${film.film_id}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script>
        $(document).ready(function () {
            $('#tableID').DataTable({
                "columnDefs": [
                    {"searchable": false, "targets": [4, 5, 6]},
                    {"orderable": false, "targets": [4, 5, 6]},
                    {"render": function (data, type, row) {
                            return  "<a href=\"CustomerController?action=addcart&film_id=" + data + "\">Add to Cart</a>";
                        }, "targets": [4]
                    },
                    {"render": function (data, type, row) {
                            return  "<a href=\"CustomerController?action=addwishlist&film_id=" + data + "\">Add to Wishlist</a>";
                        }, "targets": [5]
                    },
                    {"render": function (data, type, row) {
                            return  "<a href=\"CustomerController?action=viewdetails&film_id=" + data + "\">View Movie Details</a>";
                        }, "targets": [6]
                    }
                ]
            });
        });
    </script>
</body>
</html>
