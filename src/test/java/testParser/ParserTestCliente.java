package testParser;

import categorias.CategoriaR5;
import dispositivos.Dispositivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.MiParser;
import usuario.Cliente;
import usuario.TipoDocumento;

import java.io.IOException;

public class ParserTestCliente {

	MiParser parser;
	Cliente cliente;

	@Before

	public void setUp() throws IOException {

		parser = new MiParser();
		cliente= parser.parsearCliente("/home/matias/2018-vn-group-19/src/test/java/testParser/cliente.json");

	}

	@Test
	public void nombre() {


		Assert.assertEquals("MatiasMorsa", cliente.getNombreYApellido());
	}


	@Test
	public void tipoDocumento(){
		TipoDocumento documento = cliente.getTipoDocumento();
		Assert.assertEquals(TipoDocumento.DNI,	 documento);
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
		
		Assert.assertEquals(CategoriaR5.class,cliente.getCategoriaResidencial().getClass());
	}


	@Test
	public void dispositivo() throws IOException {

		Dispositivo dispositivo = parser.parsearDispositivo("/home/matias/2018-vn-group-19/src/test/java/dispositivo.json");
		Assert.assertEquals(dispositivo, cliente.getPrimerDispositivo());
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
