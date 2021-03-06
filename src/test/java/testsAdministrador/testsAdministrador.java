package testsAdministrador;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import usuario.Administrador;

public class testsAdministrador {

	@Test
	public void mesesComoAdministrador() {
		LocalDate haceUnMes = LocalDate.now().minusMonths(1);
		//DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//String fechaString = (haceUnMes).format(formatter_2);
		Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123",
				haceUnMes, "jperez", "123", (float) 0 ,(float) 0);
		
		
		assertEquals(1, administrador.cantidadMesesComoAdministrador(), 0.1);
	}
	
	/*
	@Test
	public void cambioNumeroIdentificacion() {
		Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123", "1/1/2018", "jperez", "123", (float) 0 ,(float) 0);
		int id = 100;
		assertEquals(id, administrador.getNumeroDeIdentificacion());
	}
	*/

}