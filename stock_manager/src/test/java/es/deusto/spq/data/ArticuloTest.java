package es.deusto.spq.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.data.Articulo.Categoria;
import es.deusto.spq.data.Cesta.Estado;
import es.deusto.spq.data_access.DAO;
import es.deusto.spq.data.Articulo;
public class ArticuloTest{
	private Articulo a1;
	private Articulo a2;
	private Articulo a3;
	private Articulo a4;
	private Vendedor v1;
	private Vendedor v2;
	private List<Articulo> listaArticulos = new ArrayList<Articulo>();
	private Date d1;
	private Date d2;
	private List<Cesta> cestas1 = new ArrayList<Cesta>();
	private List<Cesta> cestas2 = new ArrayList<Cesta>();
	private List<Cesta> cestas3 = new ArrayList<Cesta>();
	private Cesta cesta1;
	private Cesta cesta2;
	private List<Integer> cantidades1 = new ArrayList<Integer>();
	private List<Integer> cantidades2 = new ArrayList<Integer>();
	private Integer cantidad1;
	private Integer cantidad2;
	private DAO dao;
	
	
	@Before
	public void setUp(){
		d1 = new Date(2020, 04, 15);
		d2 = new Date(2020, 04, 16);
		cantidad1 = 200;
		cantidad2 = 100;
		cantidades1.add(cantidad1);
		cantidades2.add(cantidad2);
		a1 = new Articulo("coliflor", d1, 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.VERDURAS,"coliflor.com");
		a2 = new Articulo("pan", d2, 1.10f, 200, "rica pan", 1.04f,
				Categoria.FRUTOSSECOS,
				"pan.com");
		a3 = new Articulo();
		a4= new Articulo("coliflor", d2, 1.20f, 400, "rica coliflor", 1.05f,
				Categoria.VERDURAS,"coliflor.com");
		cesta1 = new Cesta(listaArticulos, cantidades1, Estado.ENCAMINO);
		cesta2 = new Cesta(listaArticulos,cantidades2,Estado.ACTUAL);
		listaArticulos.add(a1);
		listaArticulos.add(a2);
		v1 = new Vendedor("jokin", "jokin@gmail.com", listaArticulos);
		v2 = new Vendedor("jon", "jon@gmail.com", listaArticulos);
		a1.setVendedor(v1);
		a2.setVendedor(v2);
		a1.setId(9999);
		a1.setNombre("platano");
		a1.setCaducidad(new Date(15/05/2020));
		a1.setPrecio(2.15f);
		a1.setStock(50);
		a1.setDescripcion("me gusta");
		a1.setOferta(1.88f);
		a1.setCategoria(Categoria.FRUTAS);
		a1.setImageUrl("platano.com");
		
		cestas1.add(cesta1);
		cestas2.add(cesta2);
		a1.setCestas(cestas1);
		a2.setCestas(cestas2);
		a3.setCestas(cestas1);
		//a1.storeMe();
		dao = new DAO();

	}
	
	@Test
	public void testGetId() {//Comprobamos que el ID de los articulos sean distintos
		assertNotEquals(a1.getId(), a2.getId(),a3.getId());
		
	}
	@Test
	public void testSetId() {//Comprobamos que el ID, despues de hacer el set sea igual
		assertEquals(9999, a1.getId());
	}
	@Test
	public void testGetNombre() {
		assertNotEquals(a1.getNombre(),a2.getNombre(),a3.getNombre());
	}
	@Test
	public void testSetNombre() {
		assertEquals("platano", a1.getNombre());
	}
	@Test
	public void testGetCaducidad() {
		assertNotEquals(a1.getCaducidad(), a2.getCaducidad());
		assertNotEquals(a2.getCaducidad(), a3.getCaducidad());
	}
	@Test
	public void testSetCaducidad() {
		assertEquals(new Date(15/05/2020), a1.getCaducidad());
	}
	
	@Test
	public void testGetPrecio() {
		assertNotEquals(a1.getPrecio(), a2.getPrecio(),a3.getPrecio());
	}
	@Test
	public void testSetPrecio() {
		assertEquals(2.15f, a1.getPrecio(),0);
	}
	
	@Test
	public void testGetStock() {
		assertNotEquals(a1.getStock(), a2.getStock(),a3.getStock());
	}
	@Test
	public void testSetStock() {
		assertEquals(50, a1.getStock());
	}
	
	@Test
	public void testGetDescripcion() {
		assertNotEquals(a1.getDescripcion(), a2.getDescripcion(),a3.getDescripcion());
	}
	@Test
	public void testSetDescripcion() {
		assertEquals("me gusta", a1.getDescripcion());
	}
	@Test
	public void testGetOferta() {
		assertNotEquals(a1.getOferta(), a2.getOferta(),a3.getOferta());
	}
	@Test
	public void testSetOferta() {
		assertEquals(1.88f, a1.getOferta(),0);
	}
	@Test
	public void testGetCategoria() {
		assertNotEquals(a1.getCategoria(), a2.getCategoria());
		assertNotEquals(a1.getCategoria(), a3.getCategoria());
	}
	@Test
	public void testSetCategoria() {
		assertEquals(Categoria.FRUTAS, a1.getCategoria());
	}
	@Test
	public void testGetVendedor() {
		assertNotEquals(a1.getVendedor(), a2.getVendedor());
		assertNotEquals(a1.getVendedor(), a3.getVendedor());
	}
	@Test
	public void testSetVendedor() {
		assertEquals(v1, a1.getVendedor());
	}
	@Test
	public void testGetImageUrl() {
		assertNotEquals(a1.getImageUrl(), a2.getImageUrl(),a3.getImageUrl());
	}
	@Test
	public void testSetImageUrl() {
		assertEquals("platano.com", a1.getImageUrl());
	}
	@Test
	public void testEquals() {
		assertFalse(a1.equals(a2));	
		assertTrue(a1.equals(a1));	
		assertTrue(a2.equals(a2));
		
		
	}
	@Test
	public void testToString() {
		String prueba = a1.toString();
		assertNotEquals(prueba, a2.toString());
	}
	@Test
	public void testHashCode() {
		assertNotEquals(a1.hashCode(), a2.hashCode());
//		assertNotEquals(a1.hashCode(), a3.hashCode());
//		assertNotEquals(a2.hashCode(), a3.hashCode());
	}
	@Test
	public void testGetCestas() {
		assertNotEquals(a1.getCestas(), a2.getCestas());
	}
	@Test 
	public void testSetCestas() {
		assertEquals(a1.getCestas(), a3.getCestas());
	}
	@Test
	public void testStoreMe() {
		a1.storeMe();
		dao.getArticulo(a1.getId());
		assertFalse(dao.getArticulos().contains(a1));//??
	}
	@Test 
	public void testGetSerialVersionUid() {
		assertNotNull(a1);
		assertEquals(a1.getSerialVersionUid(), a2.getSerialVersionUid());
	}
	
}