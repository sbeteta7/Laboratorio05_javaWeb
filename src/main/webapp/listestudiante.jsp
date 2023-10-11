<%@ page import="com.tecsup.edu.lab05.model.Estudiante" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 5/10/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Estudiantes List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div>
        <a href="EstudianteServlet">- Registrar</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Codigo</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Email</th>
            <th scope="col">Fecha de nacimiento</th>
            <th scope="col">Universidad</th>
            <th scope="col">Carrera</th>
        </tr>
        </thead>
        <tbody>
        <%List<Estudiante> estudianteList = (List<Estudiante>) request.getAttribute("list"); %>
        <%
            for (Estudiante estudiante: estudianteList) {
        %>
        <tr>
            <td><%=estudiante.getId()%></td>
            <td><%=estudiante.getNombre()%></td>
            <td><%=estudiante.getApellido()%></td>
            <td><%=estudiante.getEmail()%></td>
            <td><%=estudiante.getBirth_date()%></td>
            <td><%=estudiante.getUniversidad()%></td>
            <td><%=estudiante.getCarrera()%></td>
            <td>
                <form action="<%= request.getContextPath() %>/DetailsEstudianteServlet" method="POST">
                    <input type="hidden" name="id" value="<%= estudiante.getId() %>">
                    <button type="submit">EDITAR</button>
                </form>

                <form action="<%= request.getContextPath() %>/DeleteEstudianteServlet" method="POST">
                    <input type="hidden" name="id" value="<%= estudiante.getId() %>">
                    <button type="submit">ELIMINAR</button>
                </form>
            </td>
        </tr>
        <%    }%>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>