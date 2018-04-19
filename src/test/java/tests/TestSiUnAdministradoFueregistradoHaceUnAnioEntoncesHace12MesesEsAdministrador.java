package tests;

import org.junit.Test;
import usuario.Administrador;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class TestSiUnAdministradoFueregistradoHaceUnAnioEntoncesHace12MesesEsAdministrador {

	@Test
	public void test() {
		Administrador administrador = new Administrador();
				administrador.inicializarAdministrador("Juan Perez", "Calle Falsa 123",
				LocalDate.now().minus(1,ChronoUnit.YEARS), "jperez", "123",3);
		
		assertEquals(12, administrador.mesesComoAdministrador());
	}

}