<%@ page import="com.tecsup.edu.lab05.model.Estudiante" %>
<%@ page import="java.util.List" %><%--
    Document   : edit
    Created on : Oct 5, 2022, 10:24:02 AM
    Author     : edu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Ingrese el DNI que desea modificar </h1>
<%Estudiante estudiante = (Estudiante) request.getAttribute("Estudiante");%>

<form action="<%= request.getContextPath()%>/EditEstudianteServlet" method="post">
    <table style="width:80%">
        <tr>
            <td>Codigo</td>
            <td><input type="text" readonly name="id"  value="<%= estudiante.getId()%>" /></td>
        </tr>
        <tr>
            <td>Nombre</td>
            <td><input type="text" name="nombre" value="<%= estudiante.getNombre() %>" /></td>
        </tr>
        <tr>
            <td>Apellido</td>
            <td><input type="text" name="apellido" value="<%= estudiante.getApellido() %>" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="<%= estudiante.getEmail() %>" /></td>
        </tr>
        <tr>
            <td>Fecha de nacimiento</td>
            <td><input type="date" name="birth" value="<%= estudiante.getBirth_date() %>"  /></td>
        </tr>
        <tr>
            <td>Universidad</td>
            <td><input type="text" name="universidad" value="<%= estudiante.getUniversidad() %>" /></td>
        </tr>

        <tr>
            <td>Carrera</td>
            <td><input type="text" name="carrera" value="<%= estudiante.getCarrera() %>" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Register" /></td>
        </tr>
    </table>

</form>
<a href="ListEstudianteServlet">- VOLVER</a>
</body>
</html>
