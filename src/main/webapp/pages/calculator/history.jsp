<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.01.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Results history for current user</title>
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
            <div class="row justify-content-md-center">
                <form action="/history" method="processRequest">
                    <h3>Results history for current user:</h3>
                    <br>
                    <ol>
                        <c:forEach var="result" items="${results}">
                            <li><h3> calculation: ${result.toString()}</h3></li>
                            <hr>
                        </c:forEach>
                    </ol>
                    <hr>
                    <hr>
                    <br>
                </form>
            </div>
            <br>
            <div class="row justify-context-md-center" role="alert">
                ${requestScope.messageErrorHistory}
            </div>
        </div>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>


