<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
	     pageEncoding="ISO-8859-1" 
	     isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>

	<h2>LOGIN</h2>
	<!-- en la siguiente linea esta el modelAttribute. esto sincroniza con el model del loginController -->
	<form:form action="login" method="post" modelAttribute="usuario">
		<form:label path="nombre">Nombre de usuario:</form:label>
		<form:input path="nombre" /><br/>
		<form:label path="clave">Clave:</form:label>
		<form:input path="clave" /><br/>
		<form:button>Login</form:button>
	</form:form>
	

</body>
</html>