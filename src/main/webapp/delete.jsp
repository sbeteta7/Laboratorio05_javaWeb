<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 9/10/2023
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<nav class="navbar bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="/docs/5.2/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
        </a>
        <p>Register Estudiante</p>
    </div>
</nav>

<div class="container">
    <form action="<%=request.getContextPath()%>/DeleteEstudianteServlet" method="post">

        <div class="mb-3">
            <label for="id" class="form-label">Identificador :</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>

        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Delete Estudiante</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>


</body>
</html>
