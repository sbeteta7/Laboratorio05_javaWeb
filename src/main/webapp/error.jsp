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
    <title>Error</title>
</head>
<body>
<h1> Ha ocurrido un error: </h1>
<h1> There was a problem with this process </h1>

<h3> There was an error : <%=request.getAttribute("message")%></h3>
<a href="ListEstudianteServlet">- VOLVER</a>
</body>
</html>