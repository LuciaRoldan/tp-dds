package testsUnitariosCliente;

import static org.junit.Assert.*;
import org.junit.Test;
import usuario.Cliente;
import usuario.TipoDocumento;
import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import java.time.LocalDate;
import java.util.ArrayList;
import dispositivos.DispositivoEstandar;

public class TestUnClienteTiene2Dispositivos {

	@Test
	public void test() {
		ArrayList <Dispositivo> dispositivos = new ArrayList <Dispositivo>();
		dispositivos.add(new Dispositivo("Dispositivo1", 1, true, new DispositivoEstandar())); 
		dispositivos.add(new Dispositivo("Dispositivo2", 1, true, new DispositivoEstandar()));
		
		Cliente cliente = new Cliente("Juan Perez", "Calle Falsa 123", LocalDate.now(), "jperez", "123", 
				TipoDocumento.DNI, 12345678, 12345678, new CategoriaR1(), dispositivos);
		
		assertEquals(2, cliente.cantidadDispositivos());
	}

}
