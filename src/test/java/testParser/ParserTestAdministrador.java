package testParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.OtroParserMasGenerico;
import usuario.Administrador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ParserTestAdministrador {

	OtroParserMasGenerico parser;
	List<Administrador> listaDeAdministradores;
	Administrador administrador;
	DateTimeFormatter formatter;

	@Before

	public void setUp() throws IOException {

		parser 			= new OtroParserMasGenerico();
		listaDeAdministradores = parser.parsear(Administrador.class, "src/test/java/testParser/administrador.json");
		administrador   = listaDeAdministradores.get(0);
		formatter= DateTimeFormatter.ofPattern("d/MM/yyyy");
	}

	@Test
	public void nombreYapellido() { Assert.assertEquals("MatiasMorsa", administrador.getNombreYApellido());}
	@Test
	public void nombreUsuario()   { Assert.assertEquals("Matias21313", administrador.getNombreUsuario());}
	@Test
	public void domicilio()       { Assert.assertEquals("Av.del libertador 2000", administrador.getDomicilio());}
	@Test
	public void contraseña()      { Assert.assertEquals("123321", administrador.getContrasena());}
	@Test
	public void fechaDeAlta()     { Assert.assertEquals(LocalDate.parse("01/01/2001",formatter), administrador.getFechaDeAlta());}

}
