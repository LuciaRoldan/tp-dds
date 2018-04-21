package testParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.MiParser;
import usuario.Administrador;
import usuario.Usuario;

import java.io.IOException;
import java.util.List;

public class ParserTestAdministrador {

	MiParser parser;
	List<Usuario> listaDeUsuarios;
	Administrador administrador;

	@Before

	public void setUp() throws IOException {

		parser = new MiParser();
		administrador = (Administrador) listaDeUsuarios.get(0);

	}

	@Test
	public void nombre() {


		Assert.assertEquals("MatiasMorsa", administrador.getNombreYApellido());
	}



	@Test
	public void nombreUsuario() {


		Assert.assertEquals("Matias21313", administrador.getNombreUsuario());
	}

	@Test
	public void domicilio() {

		Assert.assertEquals("Av.del libertador 2000", administrador.getDomicilio());
	}

	@Test
	public void contraseña() {


		Assert.assertEquals("123321", administrador.getContrasena());
	}

	@Test
	public void fechaDeAlta() {

		Assert.assertEquals("01012001", administrador.getFechaDeAlta());
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
