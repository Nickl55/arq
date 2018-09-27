
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="/res/css/estilos.css" />" rel="stylesheet">
<script type="text/javascript" src="/res/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Universidad Católica de Colombia</title>
</head>
<body>

	<h1>Bienvenido a PAW 2018</h1>

	<a class="fas fa-address-card" href='<c:url value="/estudiante" />'><img class="admin" alt="admin" src="/14-springwebapp/res/images/estudiante.png">Estudiante</a>
	<br/>
	<a href='<c:url value="/admin" />'>
	<img class="admin" alt="admin" src="/14-springwebapp/res/images/admin.png">Administrador
	</a>
	<br />
	<br />

	<c:out value="${adminForm}" />


</body>
</html>