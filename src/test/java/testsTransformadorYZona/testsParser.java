package testsTransformadorYZona;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parserTransformadorYZona.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import transformador.Transformador;

public class testsParser {

	Transformador transformador;
	ParserTransformadorYZona parser;
	
	@Before
	public void inicializar() throws NoSePudoAbrirElArchivoException{
		parser = new ParserTransformadorYZona();
		transformador = parser.parsearTransformador("src/test/java/testsTransformadorYZona/transformador.json");
	}
	
	@Test
	public void testLeerTransformador() {
		assertEquals(transformador.getClass(), Transformador.class);
	}

}
