<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body>
	<h1>Actualizar Producto</h1>
	<form action="adminProducto?action=editar" method="post">
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id"
					value="<c:out value="${producto.id}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre"
					value='<c:out value="${producto.nombreProducto}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Calificación</label></td>
				<td><input type="text" name="calificacion"
					value='<c:out value="${producto.calificacionProducto}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Descuento</label></td>
				<td><input type="text" name="descuento"
					value='<c:out value="${producto.descuentoProducto}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Estado</label></td>
				<td><input type="text" name="estado"
					value='<c:out value="${producto.estadoProducto}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Categoria</label></td>
				<td><input type="text" name="categoria"
					value='<c:out value="${producto.categoriaProducto}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Peso</label></td>
				<td><input type="text" name="peso"
					value='<c:out value="${producto.pesoEnvio}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Precio Lista</label></td>
				<td><input type="text" name="precioLista"
					value='<c:out value="${producto.precioLista}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Precio Nuestro</label></td>
				<td><input type="text" name="precioNuestro"
					value='<c:out value="${producto.nuestroPrecio}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Activo</label></td>
				<td><input type="text" name="activo"
					value='<c:out value="${producto.active}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Descripción</label></td>
				<td><input type="text" name="descripcion"
					value='<c:out value="${producto.descripcion}"></c:out>'></td>
			</tr>
			
			<tr>
				<td><label>En Stock</label></td>
				<td><input type="text" name="stock"
					value='<c:out value="${producto.inStockNumber}"></c:out>'></td>
			</tr>

		</table>

		<input type="submit" name="registrar" value="Guardar">
	</form>

</body>
</html>