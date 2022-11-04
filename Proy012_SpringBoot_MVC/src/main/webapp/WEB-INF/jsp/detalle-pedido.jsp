<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles</title>
</head>
<body>

	<h1>Detalle Pedido</h1>
	
	
	Id:${pedido.id}
	<br/>
	Descripcion:${pedido.desc}
	<br/>
	Fecha:<fm:formatDate value="${pedido.date}" pattern = "dd-MM-yyyy"/>
	<br/>
	Entregado:${pedido.entregado}
	<br/>
	



</body>
</html>