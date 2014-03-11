<%@ page language="java" contentType="text/html"%>
<%@ page
	import="com.gabrielbellon.dao.PortalDAO, java.util.*, com.gabrielbellon.model.Portal"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="extras"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Bem Vindo!</title>
</head>
<body>
	<c:import url="header.jsp" />

	<jsp:useBean id="dao" class="com.gabrielbellon.dao.PortalDAO" />

	<table border="1">
		<thead>
			<td>ID</td>
			<td>Nome</td>
			<td>Latitude</td>
			<td>Longitude</td>
			<td>Endereço</td>
			<td>Link</td>
		</thead>
		<c:forEach var="portal" items="${dao.lista}">
			<tr>
				<td>${portal.id}</td>
				<td>${portal.name}</td>
				<td>${portal.lat}</td>
				<td>${portal.lon}</td>
				<td>${portal.address}</td>
				<c:if test="${not empty portal.lat}">
					<td><a
						href="http://www.ingress.com/intel?latE6=${portal.latE6}&lngE6=${portal.lonE6}&z=14">Link
							Intel</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<c:import url="footer.jsp" />
</body>
</html>