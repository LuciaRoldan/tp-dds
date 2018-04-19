
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Cliente;

import java.io.IOException;


public class ParserTest {

	Parser parser;

	@Before

	public void setUp() throws IOException {

		parser = new Parser();
		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

	}

	@Test
	public void nombre() throws IOException {

		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("MatiasMorsa", cliente.getNombreYApellido());
	}


	@Test
	public void tipoDocumento() throws IOException{
		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");
		Assert.assertEquals("DNI", cliente.getTipoDocumento());
	}


	@Test
	public void nombreUsuario() throws IOException {

		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("Matias21313", cliente.getNombreUsuario());
	}

	@Test
	public void domicilio() throws IOException {
		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("Av.del libertador 2000", cliente.getDomicilio());
	}

	@Test
	public void telefono() throws IOException {
		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals(44444444, cliente.getTelefono());
	}

	@Test
	public void numeroDocumente() throws IOException {

		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals(1234456, cliente.getDocumento());
	}

	@Test
	public void contraseña() throws IOException {

		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("123321", cliente.getContrasena());
	}

	@Test
	public void categoriaResidencial() throws IOException {

		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("CategoriaR8", cliente.getCategoriaResidencial());
	}

	/*
	@Test
	public void fechaDeAlta() throws IOException {
		Cliente cliente = parser.parsearCliente("/home/matias/2018-vn-group-19/src/main/java/cliente.json");

		Assert.assertEquals("01012001", cliente.getFechaDeAlta());
	}

	*/

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
