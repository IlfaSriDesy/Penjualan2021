<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring BOOT MVC Example - Home JSP</title>
</head>
<body>
    <div>${title}</div>

    <c:url var="insertUser" value="/doInsertUser"></c:url>
    <c:url var="login" value="/login"></c:url>

    <button><a href="${insertUser}">insert</a></button>
    <button><a href="${login}">Login</a></button>

    <form:form id="search" action="/search" modelAttribute="search" method="POST">
        <table>
            <tr>
                <td><form:input path="cari" placeholder="cari berdasarkan username"/></td>

                <td><form:button type="submit">Cari</form:button></td>
            </tr>
        </table>
    </form:form>
    <table border="1px">
        <tr>
            <th>users id</th>
            <th>username</th>
            <th>email</th>
            <th>fullname</th>
            <th>address</th>
            <th>DELETE</th>
            <th>UPDATE</th>
            <th>NATIVE</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.usersId}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.fullname}</td>
                <td>${user.address}</td>
                <c:url var="deleteUser" value="/deleteDataUser">
                    <c:param name="usersId" value="${user.usersId}"/>
                </c:url>
                <c:url var="updateUser" value="/doUpdateDataUser">
                    <c:param name="usersId" value="${user.usersId}"/>
                </c:url>
                <c:url var="getUsers" value="/getUsers">
                </c:url>
                <td><a href="${deleteUser}">delete</a></td>
                <td><a href="${updateUser}">update</a></td>
                <td><a href="${getUsers}">NATIVE</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>