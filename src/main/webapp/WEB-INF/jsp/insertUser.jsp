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
    <form:form id="user" action="/saveUser" modelAttribute="userDto" method="POST">
            <center><table>
                    <tr>
                        <td>Username :</td>
                        <td><form:input path="username"/></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><form:input path="password"/></td>
                    </tr>
                    <tr>
                        <td>Address :</td>
                        <td><form:select path="address">
                                <form:option value="" selected="true" disabled="true">Pilih Address</form:option>
                                <c:forEach var="alamat" items="${listAddress}">
                                    <form:option value="${alamat.id}">${alamat.nm}</form:option>
                                </c:forEach>
                            </form:select></td>
                    </tr>
                    <tr>
                        <td>Email :</td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td>Fullname :</td>
                        <td><form:input path="fullname"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:button type="submit" id="save">Save</form:button>
                            </td>
                        </tr>
                    </table>
                </center>
        </form:form>
</body>
</html>