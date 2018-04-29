package testsUnitariosCliente;

import org.junit.Test;
import usuario.Cliente;

import static junit.framework.TestCase.assertEquals;

public class Test2DispositivosApagados{


	@Test
	public void test() {
		
		ClienteEstandar clienteEstandar = new ClienteEstandar();
		Cliente cliente = clienteEstandar.generarse();
		assertEquals(1, cliente.getCantidadDispositivosApagados());
	}

}
