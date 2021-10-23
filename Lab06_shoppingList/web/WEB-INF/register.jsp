<%-- 
    Document   : register
    Created on : 23-Oct-2021, 3:00:04 PM
    Author     : tweet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <div>
                <input type="submit" value="register">
            </div>
        </form>
    </body>
</html>
