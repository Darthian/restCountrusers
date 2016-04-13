<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>GESTION DE PAISES Y USUARIOS</h1>
	<a href='<c:url value="/country" />' >Gestionar Paises</a><br/>
	<a href='<c:url value="/user" />' >Gestionar Usuarios</a>
	<br/>
	<c:out value="${countryForm }"/>
	<br/>
	<c:out value="${userForm }"/>
	<br/>
</body>
</html>