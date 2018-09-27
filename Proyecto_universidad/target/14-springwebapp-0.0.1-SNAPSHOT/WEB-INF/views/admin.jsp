<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrador</title>
<link href="<c:url value="/res/css/estilos.css" />" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/res/js/jquery.js" />'></script>
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery(".confirm").on("click", function(){
		return confirm("¿Estas seguro de elminarlo?")
	});
	
});
</script>
</head>
<body>

	<h1>Administrador</h1>

	<%-- 	Atributos del model : <c:out value="${mensaje }"></c:out> --%>
	<%-- 	Atributos de la session: <c:out value="${session.Scope.resultado }"></c:out> --%>

	<sf:form action="${pageContext.request.contextPath}/admin/save"
		method="post" commandName="admin">
		<table>
			<c:if test="${admin.idAd ne 0}">
				<sf:input path="idAd" type="hidden" />
				<sf:input path="fechaCreacion" type="hidden" />
			</c:if>
			<tr>
				<td>Carnet:</td>
				<td><sf:input path="carnet" type="text" /></td>
			</tr>
			<tr>
				<td>Estudiante:</td>
				<td><sf:input path="estudiante" type="text" /></td>
			</tr>
			<tr>
				<td>Carrera:</td>
				<td><sf:input path="carrera" type="text" /></td>
			</tr>
			<tr>
				<td>Promedio</td>
				<td><sf:input path="promedio" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>

	<br />
	<c:out value="${resultado}"></c:out>
	<br />
	<br />
	<br />


	<c:forEach items="${admins}" var="admin"><br/>
		<c:out value="${admin}" />
		<!-- 		Le va a madar una URL al controlador y lo va actualizar -->
		<a href='<c:url value="/admin/${admin.idAd}/update" ></c:url>'>Modificar</a>
		<a class="confirm" href='<c:url value="/admin/${admin.idAd}/delete" ></c:url>'>Eliminar</a>
	</c:forEach>


</body>
</html>