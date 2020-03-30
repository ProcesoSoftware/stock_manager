package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class Articulo_test {
	static Date fechaC = new Date(System.currentTimeMillis());
	private static Articulo articulo= new Articulo(1, "manzana", fechaC , 1.20f, 50, "verde", 0.85f, "fruta");
	@BeforeClass
	public static void inicializarClase() {
		articulo = new Articulo();
	}
	
	@Test
	public void testgetID() {
		assertEquals(articulo.getID(), 1);
	}
	@Test
	public void testgetNombre() {
		assertEquals(articulo.getNombre(), "manzana");
	}
	@Test
	public void testgetCaducidad() {
		long millis =  System.currentTimeMillis();
		assertEquals(articulo.getCaducidad(), millis);
	}
	@Test
	public void testgetPrecio() {
		assertEquals(articulo.getPrecio(), 1.20f,0);
	}
	@Test
	public void testgetStock() {
		assertEquals(articulo.getStock(), 50);
	}
	@Test 
	public void testgetDescripcion() {
		assertEquals(articulo.getDescripcion(), "verde");
	}
	@Test
	public void testgetOferta() {
		assertEquals(articulo.getOferta(), 0.85f,0);
	}
	@Test
	public void testgetCategoria() {
		assertEquals(articulo.getCategoria(), "fruta");
	}
}
