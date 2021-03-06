package es.deusto.spq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

import org.apache.log4j.Logger;

import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data_access.DAO;

@PersistenceCapable(detachable = "true")
public class Cliente implements Serializable{
	
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(Cliente.class);
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT, primaryKey="true")
    private long id;
	@Unique
    private String emailCliente;
    private String nombreCliente;
    private String contrasenyaCliente;
    private String direccionCliente;

    @Column
    private Cesta carrito = new Cesta();
    
    @Column
    private Cesta favoritos = new Cesta();
	
    @Persistent(mappedBy = "cliente")
	private ArrayList<Cesta> pedidos = new ArrayList<>();

    public Cliente(){

    }

    public Cliente(String nombre, String email, String contrasenya, String direccion) {
        this.contrasenyaCliente = contrasenya;
        this.emailCliente = email;
        this.nombreCliente = nombre;
        this.direccionCliente = direccion;
    }

   
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getContrasenyaCliente() {
		return contrasenyaCliente;
	}

	public void setContrasenyaCliente(String contrasenyaCliente) {
		this.contrasenyaCliente = contrasenyaCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}


/*
	public void enviarMensajeServicioTecnico(int ID, Vendedor vendedor, String mensaje) {
		//Hay que crearlo
    	
	}
*/
	public Cesta getCarrito() {
		return carrito;
	}

	
	public void setCarrito(Cesta carrito) {
		this.carrito = carrito;
	}

	public Cesta getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Cesta favoritos) {
		this.favoritos = favoritos;
	}

	public ArrayList<Cesta> getPedidos(){
		return this.pedidos;
	}

	public void setPedidos(ArrayList<Cesta> pedidos){
		this.pedidos = pedidos;
	}
/*
	public void opinar(Articulo articulo, int valoracion, String texto) {
		Opinion opinion = new Opinion(texto, valoracion, this);
		DAO dao = new DAO();
		dao.store(opinion);
	}
*/	
	public String loggin(String email, String contrasenya) {
		DAO dao = new DAO();
		try {
			Cliente c = dao.getCliente(email, contrasenya);
			if(c !=null) {
				LOGGER.debug("Cliente encontrado.");
				return c.getNombreCliente();
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			LOGGER.error("Cliente no encontrado, error:" + e.getStackTrace() );
			return null;
		}
	}
		
	public void registro(String email, String nombre, String contrasenya, String direccion) {
		DAO dao = new DAO();
		Cliente c = new Cliente(email, nombre, contrasenya, direccion);
		dao.store(c);
	}

	public void registrarme() {
		DAO dao = new DAO();
		dao.store(this);
	}
	
	public void carritoToPedido(){

		Cesta c = new Cesta();

		for (Articulo articulo : this.carrito.getArticulos()){
			c.addArticulo(articulo, this.carrito.getCantidades().get(this.carrito.getArticulos().indexOf(articulo)));
		}

		this.pedidos.add(c);
		this.carrito.vaciarCesta();
		
	}

}
