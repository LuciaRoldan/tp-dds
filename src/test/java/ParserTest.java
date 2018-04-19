
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import usuario.Cliente;


public class ParserTest {
	
	Parser parser;
	Cliente cliente;
	
	@Before 
	
	public void setUp() {
		
		parser = new Parser();
		cliente = parser.parsearCliente("src/main/java/hola.json");

	}

	@Test
	public void nombre() {

		Assert.assertEquals("MatiasMorsa", cliente.getNombreYApellido());
	}

	@Test
	public void tipoDocumento() {
		Assert.assertEquals("DNI", cliente.getTipoDocumento());
	}

	@Test
	public void nombreUsuario() {
		Assert.assertEquals("Matias21313", cliente.getNombreUsuario());
	}

	@Test
	public void domicilio() {
		Assert.assertEquals("Av.del libertador 2000", cliente.getDomicilio());
	}

	@Test
	public void telefono() {
		Assert.assertEquals(44444444, cliente.getTelefono());
	}

	@Test
	public void numeroDocumente() {
		Assert.assertEquals(1234456, cliente.getDocumento());
	}

	@Test
	public void contraseña() {
		Assert.assertEquals("123321", cliente.getContrasena());
	}

	@Test
	public void categoriaResidencial() {
		Assert.assertEquals("CategoriaR8", cliente.getCategoriaResidencial());
	}

	@Test
	public void fechaDeAlta() {
		Assert.assertEquals("01012001", cliente.getFechaDeAlta());
	}

}

/*
 * Esto es lo que hay dentro de hola.json
 * {
	"nombresYapellidos": "MatiasMorsa",
	"tipoDocumento": "DNI",
	"nombreDeUsuario": "Matias21313",
	"domicilio": "Av.del libertador 2000",
	"telefono": 44444444,
	"documento": 1234456,
	"Contrasena": "123321",
	"type": "CategoriaR8",
	"FechaDeAlta": "01012001"

}
*/
