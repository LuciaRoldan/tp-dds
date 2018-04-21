package testParser;

import dispositivos.Dispositivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.MiParser;

import java.io.IOException;

public class ParserTestDispositivo {

	MiParser parser;
	Dispositivo dispositivo;

	@Before

	public void setUp() throws IOException {

		parser = new MiParser();
		dispositivo = parser.parsearDispositivo("src/test/java/dispositivo.json");

	}

	@Test
	public void nombre() {

		Assert.assertEquals("Eco Tostadora", dispositivo.getNombre());
	}
}