package testsUnitariosCliente;

import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import org.junit.Test;
import usuario.Cliente;
import usuario.TipoDocumento;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestUnClienteTiene2Dispositivos {

	@Test
	public void test() {
		ArrayList <Dispositivo> dispositivos = new ArrayList <Dispositivo>();
		dispositivos.add(new Dispositivo("Dispositivo1", Long.valueOf(1), true, new DispositivoEstandar()));
		dispositivos.add(new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar()));
		
		Cliente cliente = new Cliente();
		cliente.inicializarCliente("Juan Perez", "Calle Falsa 123", LocalDate.now(), "jperez", "123",
				TipoDocumento.DNI, 12345678, 12345678, new CategoriaR1(), dispositivos);
		
		assertEquals(2, cliente.cantidadDispositivos());
	}

}
