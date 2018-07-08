package testsTransformadorYZona;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import parserTransformadorYZona.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import transformador.Transformador;

public class testsParser {

	Transformador transformador;
	ParserTransformadorYZona parser;
	
	@Before
	public void inicializar() throws NoSePudoAbrirElArchivoException, IOException {
		parser = new ParserTransformadorYZona();
		transformador = parser.parsearTransformador("src/xd.json");
	}
	
	@Test
	public void testLeerTransformador() {
		assertEquals(transformador.getClass(), Transformador.class);
	}

}
