<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta de Pedidos</title>
</head>
<body>

	<h1>Pedidos</h1>
	<h2>Alta</h2>
	
	<!-- en la siguiente linea esta el modelAttribute. esto sincroniza con el model del loginController -->
	<h3>Usuario: ${usuario.nombre}</h3>
	
	<form:form action="alta" method="post" modelAttribute="altaPedido">
		<!-- como el usuario esta loggeado no hace falta pedir el ususario para dar de alta un pedido-->
		<!-- el id se autoincrementa en la funcion de PedidoRepositoryImp-->
		<!-- date no se pone aqui -->
		<form:label path="desc">Descripcion del pedido</form:label>
		<form:input path="desc" />
		<form:errors path="desc"></form:errors>
		<br/>
		
		<form:label path="entregado">El pedido fue entregado?</form:label>
		<form:checkbox path="entregado" />
		<br/>
		<form:button>Alta Pedido</form:button>
		
	</form:form>



</body>
</html>