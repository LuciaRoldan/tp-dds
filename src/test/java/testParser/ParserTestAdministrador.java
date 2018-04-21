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
		listaDeUsuarios = parser.parsearUsuario("/home/matias/2018-vn-group-19/src/test/java/testParser/cliente.json");
		administrador = (Administrador) listaDeUsuarios.get(1);

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
