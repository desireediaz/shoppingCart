<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Productos</title>
</head>
<body>
	<h1>Lista Productos</h1>
	<table>
		<tr>
			<td><a href="adminProducto?action=index">Ir al menú</a></td>
		</tr>
	</table>

	<table border="1" width="100%">
		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>CALIFICACIÓN</td>
			<td>DESCUENTO</td>
			<td>ESTADO</td>
			<td>CATEGORIA</td>
			<td>PESO</td>
			<td>PRECIO LISTA</td>
			<td>PRECIO NUESTRO</td>
			<td>ACTIVO</td>
			<td>DESCRIPCIÓN</td>
			<td>EN STOCK</td>
			<td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="producto" items="${lista}">
			<tr>
				<td><c:out value="${producto.id}"/></td>
				<td><c:out value="${producto.nombreProducto}"/></td>
				<td><c:out value="${producto.calificacionProducto}"/></td>
				<td><c:out value="${producto.descuentoProducto}"/></td>
				<td><c:out value="${producto.estadoProducto}"/></td>
				<td><c:out value="${producto.categoriaProducto}"/></td>
				<td><c:out value="${producto.pesoEnvio}"/></td>
				<td><c:out value="${producto.precioLista}"/></td>
				<td><c:out value="${producto.nuestroPrecio}"/></td>
				<td><c:out value="${producto.active}"/></td>
				<td><c:out value="${producto.descripcion}"/></td>
				<td><c:out value="${producto.inStockNumber}"/></td>
				<td><a
					href="adminProducto?action=showedit&id=<c:out value="${producto.id}" />">Editar</a></td>
				<td><a
					href="adminProducto?action=eliminar&id=<c:out value="${producto.id}"/>">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>