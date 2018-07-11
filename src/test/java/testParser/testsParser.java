package testParser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import exceptionParser.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import transformador.Transformador;
import zona.Zona;

public class testsParser {

	Transformador transformador;
	Zona zona;
	ParserTransformadorYZona parser;
	
	@Before
	public void inicializar() throws NoSePudoAbrirElArchivoException, IOException {
		parser = new ParserTransformadorYZona();
		transformador = parser.parsearTransformador("src/test/java/testsTransformadorYZona/transformador.json");
		zona = parser.parsearZona("src/test/java/testsTransformadorYZona/zona.json");
	}
	
	@Test
	public void testLeerTransformador() {
		assertEquals(transformador.getClass(), Transformador.class);
	}
	
	@Test
	public void testLeerZona() {
		assertEquals(zona.getClass(), Zona.class);
	}


}
