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
    <title>Calculation</title>
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
<div class="row justify-content-md-center">
    <div class="col col-lg-2">
        <p></p>
    </div>
    <div class="col-md-auto">
        <p>
            Calculation:
        </p>
        <form action="/calc" method="post">
            <label><input type="text" name="num1" placeholder="num1" required></label>
            <select name="opType">
                <option disabled selected>Select operation</option>
                <option value="+"><h3>+</h3></option>
                <option value="/"><h3>/</h3></option>
                <option value="-"><h3>-</h3></option>
                <option value="*"><h3>*</h3></option>
            </select>
            <label><input type="text" name="num2" placeholder="num2" required></label>
            <button>Calculate</button>
            <br>
        </form>
    </div>
    <div class="col col-lg-2">
        <p> </p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <p></p>
        </div>
        <div class="col-sm-9">
            <div class="row">
                <div class="col-8 col-sm-6">
                    <p>Result: ${requestScope.messageCalculator}</p>
                </div>
                <div class="col-4 col-sm-6">
                    <p></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row justify-content-md-center">
    <div class="row justify-context-md-center" role="alert">
        <br>
        ${requestScope.messageErrorCalculator}
        <br>
    </div>
</div>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
