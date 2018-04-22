package testCategoriaResidencial;

import categorias.CategoriaR1;
import categorias.CategoriaResidencial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Cliente;

public class TestCategoriaR1 {

	Cliente cliente;
	CategoriaResidencial categoria;

	@Before

	public void setUp()				{ categoria = new CategoriaR1();}

	@Test
	public void getCargoVariable()  { Assert.assertEquals(Double.valueOf(0.644),categoria.getCargoVariable());	}
	@Test
	public void getCargoFijo() 		{ Assert.assertEquals(Double.valueOf(18.76),categoria.getCargoFijo() );		}
	@Test
	public void noPertenece() 		{ Assert.assertEquals(true,categoria.pertenece(1.00));		}
	@Test
	public void siPertenece() 		{ Assert.assertEquals(false,categoria.pertenece(2500.00)); }
	@Test
	public void getNombre() 		{ Assert.assertEquals("CATEGORIAR1",categoria.getNombre() );		 }

}