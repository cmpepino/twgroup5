<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
	<h2>Lista de Pedidos del cliente ${usuario.nombre}!!</h2>

	<ul>
		<c:forEach items="${listaPedido}" var="pedido">
			<li>${pedido.id}-${pedido.desc} - 
			<a href="/pedido?idPedido=${pedido.id}">Ver Detalle</a> -
			<c:if test="${usuario.rol eq 'admin' }">
				<a href="pedido/delete?id=${pedido.id}">Eliminar</a>
			</c:if>
			</li>

		</c:forEach>
	</ul>
	
	<a href="/alta">Hacer un nuevo pedido</a>



</body>
</html>