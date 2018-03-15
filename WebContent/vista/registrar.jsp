<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body>
	<h1>Registrar Producto</h1>
	<form action="adminProducto?action=registrar" method="post">
		<table border="1" align="center">
		<tr>
			<td>Nombre:</a></td>		
			<td><input type="text" name="nombre"/></td>	
		</tr>
		<tr>
			<td>Calificación:</a></td>		
			<td><input type="text" name="calificacion"/></td>	
		</tr>
		<tr>
			<td>Descuento:</a></td>		
			<td><input type="text" name="descuento"/></td>	
		</tr>
		<tr>
			<td>Estado:</a></td>		
			<td><input type="text" name="estado"/></td>	
		</tr>
		<tr>
			<td>Categoria:</a></td>		
			<td><input type="text" name="categoria"/></td>	
		</tr>		
		
		<tr>
			<td>Peso:</a></td>		
			<td><input type="text" name="peso"/></td>	
		</tr>	
		
		<tr>
			<td>Precio Lista:</a></td>		
			<td><input type="text" name="precioLista"/></td>	
		</tr>	
		
		<tr>
			<td>Precio Nuestro:</a></td>		
			<td><input type="text" name="precioNuestro"/></td>	
		</tr>	
		
		<tr>
			<td>Activo:</a></td>		
			<td><input type="text" name="activo"/></td>	
		</tr>	
		
		<tr>
			<td>Descripción:</a></td>		
			<td><input type="text" name="descripcion"/></td>	
		</tr>	
		
				<tr>
			<td>En Stock:</a></td>		
			<td><input type="text" name="stock"/></td>	
		</tr>	
		
	</table>
	<br>
	<table border="0" align="center">
		<tr>
		<td><input type="submit" value="Agregar" name="agregar"></td>	
		</tr>
	
	</form>
</body>
</html>