package es.deusto.spq.clases;

public class Vendedor {
	private int ID_vendedor;
	private String nombre_vendedor;
	private String email_vendedor;
	public int getID() {
		return ID_vendedor;
	}

	public void setID(int iD) {
		ID_vendedor = iD;
	}

	public String getNombre() {
		return nombre_vendedor;
	}

	public void setNombre(String nombre) {
		this.nombre_vendedor = nombre;
	}

	public String getEmail() {
		return email_vendedor;
	}

	public void setEmail(String email) {
		this.email_vendedor = email;
	}

	public Vendedor(int iD, String nombre, String email) {
		super();
		this.ID_vendedor = iD;
		this.nombre_vendedor = nombre;
		this.email_vendedor = email;
	}

	public Vendedor(int iD) {
		super();
		this.ID_vendedor = iD;
	}

	@Override
	public String toString() {
		return "ID del vendedor=" + ID_vendedor + ", nombre=" + email_vendedor + ", email=" + email_vendedor + "]";
	}
	

}
