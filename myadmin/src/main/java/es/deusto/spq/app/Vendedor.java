package src.main.java.es.deusto.spq.app;

import java.io.Serializable;

import java.util.List;




public class Vendedor implements Serializable {
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private long id;
	private String nombre_vendedor;
	private String email_vendedor;
	
	private List<Articulo> articulos;
	
	public Vendedor(){
		
	}
	
	public Vendedor(String nombre, String email, List<Articulo> articulos) {
		this.nombre_vendedor = nombre;
		this.email_vendedor = email;
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre_vendedor + ", email=" + email_vendedor + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_vendedor() {
		return nombre_vendedor;
	}

	public void setNombre_vendedor(String nombre_vendedor) {
		this.nombre_vendedor = nombre_vendedor;
	}

	public String getEmail_vendedor() {
		return email_vendedor;
	}

	public void setEmail_vendedor(String email_vendedor) {
		this.email_vendedor = email_vendedor;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
//	
//	public void addArticulo(Articulo articulo) {
//		this.articulos.add(articulo);
//		DAO dao = new DAO();
//		dao.store(this);
//	}
//
//	public void registrar() {
//		DAO dao = new DAO();
//		dao.store(this);
//	}

}
