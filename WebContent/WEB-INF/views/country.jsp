<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Gestion de paises</title>
	<script type="text/javascript" src='<c:url value="/res/js/jquery.js" />' ></script>
	<script type="text/javascript">
		$(document).ready(function(){
// 			alert("jQuery esta cargado carajo O_O");
			console.log("Se ejecuta el document ready");
			$(".confirm").on("click", function(){
				console.log("Se ejecuta el confirm");
				return confirm("Si confirmas la informacion no se podra recuperar");
			});
		});
	</script>
</head>
<body>
	<h1>GESTION DE PAISES</h1>
	<a href='<c:url value="/" />' >volver</a>

	<sf:form action="${pageContext.request.contextPath}/country/save" method="post" commandName="country">	
	<table>
<%-- 		<c:if test="${country.idCountry eq 0} "> --%>
			<sf:input path="idCountry" type="hidden"/>
<%-- 		</c:if> --%>
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
	
	<c:forEach items="${countries}" var="country">
		<br/><c:out value="${country}"></c:out>
		<a href='<c:url value="/country/${country.idCountry}/update" />'>Actualizar</a>
		<a class="confirm" href='<c:url value="/country/${country.idCountry}/delete" />'>Eliminar</a>
	</c:forEach>
	
</body>
</html>