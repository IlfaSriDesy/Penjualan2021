<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring BOOT MVC Example - Home JSP</title>
</head>
<body>
    <div>${title}</div>
    <table border="1px">
        <tr>
            <th>users id</th>
            <th>username</th>
            <th>email</th>
            <th>fullname</th>
            <th>address</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.usersId}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.fullname}</td>
                <td>${user.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>