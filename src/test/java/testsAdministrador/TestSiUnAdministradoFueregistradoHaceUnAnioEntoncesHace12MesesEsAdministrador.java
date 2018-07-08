package testsAdministrador;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import usuario.Administrador;

public class TestSiUnAdministradoFueregistradoHaceUnAnioEntoncesHace12MesesEsAdministrador {

	@Test
	public void test() {
		Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123",
				"08/07/2017", "jperez", "123",3);
		
		assertEquals(12, administrador.cantidadMesesComoAdministrador());
		//CORREGIR ESTE TEST, VA A FALLAR POR EL 13 , LA CANTIDAD VA A VARIAR CUANDO VAYA PASANDO EL TIEMPO //
	}

}