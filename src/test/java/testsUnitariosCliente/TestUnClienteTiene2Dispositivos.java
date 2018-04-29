package testsUnitariosCliente;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestUnClienteTiene2Dispositivos {



	@Test
	public void test() {
		ArrayList<Dispositivo> dispositivos = new ArrayList <Dispositivo>();
		dispositivos.add(new Dispositivo("Dispositivo1", Long.valueOf(1), true, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar()));
		
		Cliente cliente = new Cliente("Juan Perez", "Calle Falsa 123", "01012001", "jperez", "123",
				TipoDocumento.DNI, 12345678, 12345678, CategoriaResidencial.CATEGORIAR1, dispositivos);
		
		assertEquals(2, cliente.getCantidadDispositivos());
	}

}
