<%-- 
    Document   : shoppingList
    Created on : 23-Oct-2021, 3:00:20 PM
    Author     : Cameron Bird
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${user}</p> 
        
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        <%-- Form to Add Items --%>
        <form action="" method="POST">
            <h3>Add item</h3>
            <input type="text" name="item"><input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        <%-- Form to Display items --%>
        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${itemList}">
                    <li>
                        <c:out value="${item}" /> 
                        <input type="radio" name="addeditems" value="${item}">
                    </li>    
                </c:forEach>
            </ul>
            <input type="submit" value="Delete Item">
            <input type="hidden" name="action" value="delete">
        </form>
        
    </body>
</html>
