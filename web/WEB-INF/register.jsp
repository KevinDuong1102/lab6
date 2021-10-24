<%-- 
    Document   : register
    Created on : Oct 17, 2021, 3:36:05 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method ="POST">
            <label>Username:</label>
            <input type="text" name="username" />
            <input type="hidden" name="action" value="register"/>
            
            <input type ="submit" value ="Register name"/>
            
        </form>
    </body>
</html>
