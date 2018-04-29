package testsUnitariosCliente;

import org.junit.Test;
import categorias.CategoriaR1;
import usuario.Cliente;
import testsUnitariosCliente.ClienteEstandar;

import static junit.framework.TestCase.assertEquals;

public class TestRecategorizacionCliente {
	
	@Test
	public void testRecategorizacion() {
	
		ClienteEstandar clienteEstandar = new ClienteEstandar();
		Cliente cliente = clienteEstandar.generarse();
		cliente.recategorizarse();
		assertEquals(CategoriaR1.class, cliente.getCategoriaResidencial().getClass());
	}
}
