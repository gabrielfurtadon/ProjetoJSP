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
<%-- <% out.println("Boa tarde"); %> --%>
 

<form action="servletLogin" method="post">
<input type="hidden" value="<%= request.getParameter("url")%>" name="url"> <!-- QUANDO COLOCAR UMA VALOR DENTRO DE UMA TAG VALUE TEM QUE COLOCAR O = -->
<!-- TABELA DE LOGIN -->
<table>
	<tr>
		<td><label>Login :</label></td>
		<td><input name="login" type="text"> <!-- name = variavel setada --></td>
	</tr>
	<tr>
		<td><label>Senha :</label></td>
		<td><input name="senha" type="password"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Enviar"></td>
	</tr>
</table>

</form>

<h4>${msg}</h4>


</body>
</html>