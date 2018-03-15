package com.shoppingcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Conexion;
import com.shoppingcart.model.Producto;

public class ProductoDAO {

	private Conexion con;
	private Connection connection;

	public ProductoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar productos
	public boolean insertar(Producto producto) throws SQLException {
		String sql = "INSERT INTO producto (id, nombre_producto, calificacion_producto, descuento_producto, estado_producto, categoria_producto, peso_envio, precio_lista,  nuestro_precio, active, descripcion, in_stock_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, producto.getNombreProducto());
		statement.setString(3, producto.getCalificacionProducto());
		statement.setString(4, producto.getDescuentoProducto());
		statement.setString(5, producto.getEstadoProducto());
		statement.setString(6, producto.getCategoriaProducto());
		statement.setDouble(7, producto.getPesoEnvio());
		statement.setDouble(8, producto.getPrecioLista());
		statement.setDouble(9, producto.getNuestroPrecio());
		statement.setBoolean(10, producto.isActive());
		statement.setString(11, producto.getDescripcion());
		statement.setInt(12, producto.getInStockNumber());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Producto> listarProductos() throws SQLException {

		List<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "SELECT * FROM producto";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			Long id = resulSet.getLong("id");
			String nombreProducto = resulSet.getString("nombre_producto");
			String calificacionProducto = resulSet.getString("calificacion_producto");
			String descuentoProducto = resulSet.getString("descuento_producto");
			String estadoProducto = resulSet.getString("estado_producto");
			String categoriaProducto = resulSet.getString("categoria_producto");
			double pesoEnvio = resulSet.getDouble("peso_envio");
			double precioLista = resulSet.getDouble("precio_lista");
			double nuestroPrecio = resulSet.getDouble("nuestro_precio");
			boolean active = resulSet.getBoolean("active");
			String descripcion = resulSet.getString("descripcion");
			int inStockNumber = resulSet.getInt("in_stock_number");

			Producto producto = new Producto(id, nombreProducto, calificacionProducto, descuentoProducto,
					estadoProducto, categoriaProducto, pesoEnvio, precioLista, nuestroPrecio, active, descripcion,
					inStockNumber);
			listaProductos.add(producto);

		}
		con.desconectar();
		return listaProductos;
	}

	// obtener por id
	public Producto obtenerPorId(long id) throws SQLException {
		Producto producto = null;

		String sql = "SELECT * FROM producto WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			producto = new Producto(res.getLong("id"), res.getString("nombre_producto"),
					res.getString("calificacion_producto"), res.getString("descuento_producto"),
					res.getString("estado_producto"), res.getString("categoria_producto"), res.getDouble("peso_envio"),
					res.getDouble("precio_lista"), res.getDouble("nuestro_precio"), res.getBoolean("active"),
					res.getString("descripcion"), res.getInt("in_stock_number"));
		}
		res.close();
		con.desconectar();

		return producto;
	}

	// actualizar
	public boolean actualizar(Producto producto) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE producto SET nombre_producto=?,calificacion_producto=?,descuento_producto=?,estado_producto=?, categoria_producto=?,peso_envio=?, precio_lista=?,nuestro_precio=?,active=?,descripcion=?, in_stock_number=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, producto.getNombreProducto());
		statement.setString(2, producto.getCalificacionProducto());
		statement.setString(3, producto.getDescuentoProducto());
		statement.setString(4, producto.getEstadoProducto());
		statement.setString(5, producto.getCategoriaProducto());
		statement.setDouble(6,producto.getPesoEnvio());
		statement.setDouble(7, producto.getPrecioLista());
		statement.setDouble(8, producto.getNuestroPrecio());
		statement.setBoolean(9, producto.isActive());
		statement.setString(10, producto.getDescripcion());
		statement.setInt(11, producto.getInStockNumber());
		statement.setLong(12, producto.getId());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}

	public boolean eliminar(Producto producto) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM producto WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, producto.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}