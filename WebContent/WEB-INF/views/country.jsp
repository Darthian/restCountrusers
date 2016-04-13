<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Gestion de paises</title>
</head>
<body>
	<h1>GESTION DE PAISES</h1>
	<a href='<c:url value="/" />' >volver</a>

	<sf:form action="${pageContext.request.contextPath}/country/save" method="post" commandName="country">	
	<table>
		<input name="state" type="text" />
		<tr>
			<td>Nombre:</td>
			<td><sf:input path="name" type="text"/></td>
		</tr>
		<tr>
			<td>Departamento:</td>
			<td><sf:input path="department" type="text"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><sf:input path="city" type="text"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Guardar Cambios"/></td>
		</tr>
	</table>
	</sf:form>
	<br/>
	<c:out value="${result}"></c:out>
</body>
</html>