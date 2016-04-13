<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>ABOUT</h1>
	Mensaje desde el modelo: <c:out value="${sessionScope.mensaje}" /><br/>
	Mensaje desde Session: <c:out value="${sessionScope.resultado}" /><br/>
	<a href='<c:url value="/" />'>Volver</a>
</body>
</html>