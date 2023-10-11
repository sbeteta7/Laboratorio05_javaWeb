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
    <title>Success</title>
</head>
<body>

<h1> Added success </h1>

<h3> Filas afectadas : <%=request.getAttribute("rowsaffected")%></h3>
<a href="ListEstudianteServlet">- VOLVER</a>
</body>
</html>