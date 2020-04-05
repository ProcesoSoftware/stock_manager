package es.deusto.spq.data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceAware;

@PersistenceAware
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	
	private String nombre;
	private String contrasenya;
	
	public Usuario() {

	}
	
	public Usuario(String usuario, String contrasenya) {
		this.nombre = usuario;
		this.contrasenya = contrasenya;
	}
	
	
	public String getUser() {
		return nombre;
	}
	public void setUsuario(String usuario) {
		this.nombre = usuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}