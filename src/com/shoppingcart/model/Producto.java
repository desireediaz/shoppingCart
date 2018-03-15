package com.shoppingcart.model;

public class Producto {

	private Long id;
	private String nombreProducto;
	private String calificacionProducto;
	private String descuentoProducto;
	private String estadoProducto;
	private String categoriaProducto;
	private double pesoEnvio;
	private double precioLista;
	private double nuestroPrecio;
	private boolean active = true;
	private String descripcion;
	private int inStockNumber;
	// private MultipartFile productoImagen;
	// private List<RelacionCarritoProducto> relacionCarritoProductoList;

	public Producto(Long id, String nombreProducto, String calificacionProducto, String descuentoProducto,
			String estadoProducto, String categoriaProducto, double pesoEnvio, double precioLista, double nuestroPrecio,
			boolean active, String descripcion, int inStockNumber) {
//		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.calificacionProducto = calificacionProducto;
		this.descuentoProducto = descuentoProducto;
		this.estadoProducto = estadoProducto;
		this.categoriaProducto = categoriaProducto;
		this.pesoEnvio = pesoEnvio;
		this.precioLista = precioLista;
		this.nuestroPrecio = nuestroPrecio;
		this.active = active;
		this.descripcion = descripcion;
		this.inStockNumber = inStockNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCalificacionProducto() {
		return calificacionProducto;
	}

	public void setCalificacionProducto(String calificacionProducto) {
		this.calificacionProducto = calificacionProducto;
	}

	public String getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(String descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public double getPesoEnvio() {
		return pesoEnvio;
	}

	public void setPesoEnvio(double pesoEnvio) {
		this.pesoEnvio = pesoEnvio;
	}

	public double getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(double precioLista) {
		this.precioLista = precioLista;
	}

	public double getNuestroPrecio() {
		return nuestroPrecio;
	}

	public void setNuestroPrecio(double nuestroPrecio) {
		this.nuestroPrecio = nuestroPrecio;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getInStockNumber() {
		return inStockNumber;
	}

	public void setInStockNumber(int inStockNumber) {
		this.inStockNumber = inStockNumber;
	}

	// public MultipartFile getProductoImagen() {
	// return productoImagen;
	// }
	//
	// public void setProductoImagen(MultipartFile productoImagen) {
	// this.productoImagen = productoImagen;
	// }
	//
	// public List<RelacionCarritoProducto> getRelacionCarritoProductoList() {
	// return relacionCarritoProductoList;
	// }
	//
	// public void setRelacionCarritoProductoList(List<RelacionCarritoProducto>
	// relacionCarritoProductoList) {
	// this.relacionCarritoProductoList = relacionCarritoProductoList;
	// }
	//

}
