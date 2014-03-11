<%@ page language="java" contentType="text/html"%>
<%@ page
	import="com.gabrielbellon.dao.PortalDAO, java.util.*, com.gabrielbellon.model.Portal"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="extras"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Portal</title>
</head>
<body>
<body>
	<c:import url="header.jsp" />
	<form action="mvc" method="POST">
		Nome: <input type="text" name="nome" /><br /> 
		Latitude: <input type="text" name="lat" /><br /> 
		Latitude: <input type="text" name="lon" /><br /> 
		Endereço: <input type="text" name="endereco" /><br />
		<input type="hidden" name="logica" value="AdicionaPortalLogic" />
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="footer.jsp" />
</body>
</html>