<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Created by IntelliJ IDEA.
User: User
Date: 25.01.2022
Time: 20:22
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${sessionScope.username == null}">
        <title>Welcome to Calculator! Authorization or Registration page</title>
    </c:if>
    <c:if test="${sessionScope.username != null}">
        <title>Calculation page</title>
    </c:if>

    <%--        /*.my-button{*/--%>
    <%--        /*    color: aquamarine;*/--%>
    <%--        /*    background-color: blue;*/--%>
    <%--        /*}*/--%>
    <%--    <link rel="stylesheet" href="styles.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand">Calculator</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <c:if test="${sessionScope.username == null}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/registration">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/authorization">Authorization</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.username != null}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/calc">Calculator</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/history">Operations history</a>
                    </li>
                    <li class="nav-item">
                        <form action="/logout">
                            <button class="btn btn-outline-success" type="submit">Logout</button>
                        </form>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<br>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <c:if test="${sessionScope.username == null}">
                <h1>Welcome to Calculator!</h1>
            </c:if>
            <h3>${requestScope.messageLogout}</h3></p>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

