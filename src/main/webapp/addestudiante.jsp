<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 5/10/2023
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Estudiante Register Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
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
    <form action="<%=request.getContextPath()%>/EstudianteServlet" method="post">

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre :</label>
            <input type="text" class="form-control" id="nombre" name="nombre">
        </div>

        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido :</label>
            <input type="text" class="form-control" id="apellido" name="apellido">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email :</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>

        <div class="mb-3">
            <label for="birth_date" class="form-label">Fecha de nacimiento :</label>
            <input type="date" class="form-control" id="birth_date" name="birth_date" >
        </div>

        <div class="mb-3">
            <label for="universidad" class="form-label">Universidad :</label>
            <input type="text" class="form-control" id="universidad" name="universidad" >
        </div>

        <div class="mb-3">
            <label for="carrera" class="form-label">Carrera :</label>
            <input type="text" class="form-control" id="carrera" name="carrera" >
        </div>

        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Add Estudiante</button>
        </div>

    </form>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>