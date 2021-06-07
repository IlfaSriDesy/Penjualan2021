<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${contextPath}/webjars/bulma/0.9.1/css/bulma.min.css"/>
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/login.css"/>

        <title>Pelatihan Java</title>
    </head>
    <body>
        <div class="columns">
            <div class="column is-4 is-offset-4">
                <form class="box">
                    <h3 class="title is-3">Login</h3>
                    <div class="field">
                        <label class="label">Username</label>
                        <div class="control">
                            <input class="input"
                                   id="username"
                                   name="username"
                                   type="text"
                                   placeholder="Username">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Password</label>
                        <div class="control">
                            <input class="input"
                                   id="password"
                                   name="password"
                                   type="password"
                                   placeholder="********">
                        </div>
                    </div>

                    <button class="button is-primary">Sign in</button>
                </form>
                <div id="notif-success" class="notification is-success" hidden="true">
                    <button class="delete"></button>
                    Primar lorem ipsum dolor sit amet, consectetur
                </div>
                <div id="notif-fail" class="notification is-danger" hidden="true">
                    <button class="delete"></button>
                    Primar lorem ipsum dolor sit amet, consectetur
                </div>
            </div>

        </div>

        <script src="${contextPath}/webjars/jquery/3.5.1/jquery.min.js"></script>
        <script src="${contextPath}/js/login.js"></script>
    </body>
</html>