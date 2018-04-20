package testsUnitariosCliente;

import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import org.junit.Test;
import usuario.Cliente;
import usuario.TipoDocumento;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestUnClienteTiene3DispositivosApagados {


	@Test
	public void test() {
		ArrayList <Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		dispositivos.add(new Dispositivo("Dispositivo1", Long.valueOf(1), false, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo3", Long.valueOf(1), true, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo4", Long.valueOf(1), false, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo5", Long.valueOf(1), true, new DispositivoEstandar()));
		
		Cliente cliente = new Cliente().inicializar("Juan Perez", "Calle Falsa 123", "020202", "jperez", "123",
				TipoDocumento.DNI, 12345678, 12345678, new CategoriaR1(), dispositivos);
		
		assertEquals(2, cliente.cantidadDispositivosApagados());
	}


}
