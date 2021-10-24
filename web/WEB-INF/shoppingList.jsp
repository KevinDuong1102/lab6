<%-- 
    Document   : shoppingList
    Created on : Oct 17, 2021, 3:36:21 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>${test}</p>
        <p>Hello,${username}</p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        <form action="" method="POST">
            <label>Add item: </label>
            <input type="text" name="user_input_addItem"/>
            <input type="submit" value="Add"/>
            <input type="hidden" name="action" value="add"/>
        </form> 

        <form action='' method="post">

            <c:forEach var ='item' items='${item_list}'>
                <c:if test="${item != null}">
                    <input type="radio" name="item_radio_group" value="${item}"/> ${item} <br/>
                </c:if>


            </c:forEach>

            <input type='submit' value='Delete' />
            <input type="hidden" name="action" value="delete"/>
        </form>

    </body>
</html>
