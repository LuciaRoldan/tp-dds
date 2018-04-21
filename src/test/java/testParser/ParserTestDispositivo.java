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

	@Test
	public void tipoDeDispositivo() {

		Assert.assertEquals("INTELIGENTE", dispositivo.getTipoDeDispositivo().getNombre());
	}
	@Test
	public void kWh() {

		Assert.assertEquals("1", dispositivo.getkWh());
	}


	@Test
	public void encendido() {

		Assert.assertEquals(true, dispositivo.isEncendido());
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
