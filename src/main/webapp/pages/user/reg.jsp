<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.01.2022
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Back</a>
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
                        <a class="nav-link active" aria-current="page" href="/">Back</a>
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
<div class="container" >
    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <form action="/registration" method="post">
                <h3>Registration form:</h3>
                <br>
                <div class="row justify-content-md-center">
                    <label><input type="text" name="name" placeholder="Name" required> Name</label>
                </div>
                <br>
                <div class="row justify-content-md-center">
                    <label><input type="text" name="username" placeholder="Username" required> Username</label>
                </div>
                <br>
                <div class="row justify-content-md-center">
                    <label><input type="text" name="password" placeholder="Password" required> Password</label>
                </div>
                <br>
<%--                <div class="row justify-content-md-center">--%>
<%--                    <label><input type="number" name="roleId" placeholder="RoleId" required> RoleId (1 - for user, 2 - for admin)</label>--%>
<%--                </div>--%>
<%--                <br>--%>
                <div class="row justify-content-md-center">
                    <label><input type="text" name="email" placeholder="@mail" required> @mail</label>
                </div>
                <br>
                <div class="row justify-content-md-center">
                    <label><input type="text" name="secretQuestion" placeholder="Secret question" required> Secret question</label>
                </div>
                <br>
                <div class="row justify-context-md-center">
                    <button>Submit</button>
                </div>
                <br>
                <div class="row justify-context-md-center" role="alert">
                    ${requestScope.messageErrorRegistration}
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>



