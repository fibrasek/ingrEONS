<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Editar Portal</title>
</head>
<body>
	<c:import url="header.jsp" />

	Formulário para alterar portal:
	<br />

	<form action="mvc" method="POST">
		ID: <input type="text" name="id" /> <br /> 
		Nome: <input type="text" name="name" /> <br /> 
		Latitude: <input type="text" name="lat" /><br />
		Longitude: <input type="text" name="lon" /><br /> 
		Endereço: <input type="text" name="address" /><br />
		 
		<input type="hidden" name="logica" value="AlteraPortalLogic" /> 
		<input type="submit" value="Enviar">
	</form>
	
	<c:import url="footer.jsp" />
</body>
</html>