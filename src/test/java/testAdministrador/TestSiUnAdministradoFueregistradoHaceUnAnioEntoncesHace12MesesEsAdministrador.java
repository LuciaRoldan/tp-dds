package testAdministrador;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import usuario.Administrador;

public class TestSiUnAdministradoFueregistradoHaceUnAnioEntoncesHace12MesesEsAdministrador {

	@Test
	public void test() {
		Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123",
				"24/04/2017", "jperez", "123",3);
		
		assertEquals(12, administrador.cantidadMesesComoAdministrador());
	}

}