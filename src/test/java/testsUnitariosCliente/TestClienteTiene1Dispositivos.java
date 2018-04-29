package testsUnitariosCliente;

import org.junit.Test;
import usuario.Cliente;
import testsUnitariosCliente.ClienteEstandar;

import static junit.framework.TestCase.assertEquals;

public class TestClienteTiene1Dispositivos {


	@Test
	public void test() {
		ClienteEstandar clienteEstandar = new ClienteEstandar();
		Cliente cliente = clienteEstandar.generarse();
		assertEquals(5, cliente.getCantidadDispositivos());
	}

}
