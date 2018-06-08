package testCategoriaResidencial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import usuario.Cliente;

public class TestCategoriaR5 {

	Cliente cliente;
	CategoriaResidencial categoria;

	@Before

	public void setUp() {
		categoria = CategoriaResidencial.CATEGORIAR5;
	}

	@Test
	public void getCargoVariable() {
		Assert.assertEquals(Double.valueOf(0.794), categoria.getCargoVariable());
	}

	@Test
	public void getCargoFijo() {
		Assert.assertEquals(Double.valueOf(110.38), categoria.getCargoFijo());
	}

	@Test
	public void noPertenecePorMaximo() {
		Assert.assertEquals(false, categoria.pertenece(500.01));
	}

	@Test
	public void noPertenecePorMinimo() {
		Assert.assertEquals(false, categoria.pertenece(449.99));
	}

	@Test
	public void siPertenece() {
		Assert.assertEquals(true, categoria.pertenece(450.99));
	}

	@Test
	public void getNombre() {
		Assert.assertEquals("CATEGORIA5", categoria.getNombre());
	}

}