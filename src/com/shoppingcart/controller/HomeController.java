package com.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.dao.ProductoDAO;
import com.shoppingcart.model.Producto;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/adminProducto")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoDAO productoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			productoDAO = new ProductoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				System.out.println("ingresó al case de index");
				index(request, response);
				break;
			case "nuevo":
				System.out.println("ingresó al case de nuevo");
				nuevo(request, response);
				break;
			case "registrar":
				System.out.println("ingresó al case de registrar");
				registrar(request, response);
				break;
			case "mostrar":
				System.out.println("ingresó al case de mostrar");
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		mostrar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Producto producto = new Producto(
				(long) 0, 
				request.getParameter("nombre"),
				request.getParameter("calificacion"), 
				request.getParameter("descuento"),
				request.getParameter("estado"), 
				request.getParameter("categoria"),
				Double.parseDouble(request.getParameter("peso")),
				Double.parseDouble(request.getParameter("precioLista")),
				Double.parseDouble(request.getParameter("precioNuestro")),
				Boolean.parseBoolean(request.getParameter("activo")), 
				request.getParameter("descripcion"),
				Integer.parseInt(request.getParameter("stock")));
		productoDAO.insertar(producto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrar.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Producto> listaProductos = productoDAO.listarProductos();
		request.setAttribute("lista", listaProductos);
		dispatcher.forward(request, response);
	}

	private void showEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Producto producto = productoDAO.obtenerPorId(Long.valueOf(request.getParameter("id")).longValue());
		request.setAttribute("producto", producto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		Producto producto = new Producto(
				Long.parseLong(request.getParameter("id")),
				request.getParameter("nombre"),
				request.getParameter("calificacion"),
				request.getParameter("descuento"), 
				request.getParameter("estado"),
				request.getParameter("categoria"), 
				Double.parseDouble(request.getParameter("peso")),
				Double.parseDouble(request.getParameter("precioLista")),
				Double.parseDouble(request.getParameter("precioNuestro")),
				Boolean.parseBoolean(request.getParameter("activo")), 
				request.getParameter("descripcion"),
				Integer.parseInt(request.getParameter("stock")));
		productoDAO.actualizar(producto);
		index(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Producto producto = productoDAO.obtenerPorId(Long.valueOf(request.getParameter("id")).longValue());
		productoDAO.eliminar(producto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}
}