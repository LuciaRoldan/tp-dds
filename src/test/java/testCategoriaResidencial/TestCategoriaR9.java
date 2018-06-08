package testCategoriaResidencial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import usuario.Cliente;

public class TestCategoriaR9 {

	Cliente cliente;
	CategoriaResidencial categoria;

	@Before

	public void setUp() {
		categoria = CategoriaResidencial.CATEGORIAR9;
	}

	@Test
	public void getCargoVariable() {
		Assert.assertEquals(Double.valueOf(0.851), categoria.getCargoVariable());
	}

	@Test
	public void getCargoFijo() {
		Assert.assertEquals(Double.valueOf(887.19), categoria.getCargoFijo());
	}

	@Test
	public void noPertenece() {
		Assert.assertEquals(false, categoria.pertenece(1399.00));
	}

	@Test
	public void siPertenece() {
		Assert.assertEquals(true, categoria.pertenece(1400.01));
	}

	@Test
	public void getNombre() {
		Assert.assertEquals("CATEGORIA9", categoria.getNombre());
	}

}