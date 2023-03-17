<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página JSP</title>
</head>
<body>

<h1>Treinamento JSP</h1>
<% out.println("Boa tarde"); %>


<form action="servletLogin" method="post">
Nome :<input name="nome"> <!-- name = variavel setada -->
Idade :<input name="idade">

<input type="submit" value="Enviar">
</form>

</body>
</html>