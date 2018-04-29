package testsUnitariosCliente;

import org.junit.Test;
import usuario.Cliente;
import testsUnitariosCliente.ClienteEstandar;

import static junit.framework.TestCase.assertEquals;

public class TestConsumoCliente {
	
	
	@Test
	public void testCalcularConsumoMensual() {
		ClienteEstandar clienteEstandar = new ClienteEstandar();
		Cliente cliente = clienteEstandar.generarse();
		assertEquals((double) 4, cliente.calcularConsumoMensual());
	}

}
