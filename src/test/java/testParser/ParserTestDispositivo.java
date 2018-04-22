package testParser;

import dispositivos.DispositivoInteligente;
import dispositivos.TipoDeDispositivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;
import usuario.Cliente;

import java.io.IOException;
import java.util.List;

public class ParserTestDispositivo {

	Parser parser;
	List<Cliente> listaDeClientes;
	Cliente cliente;
	TipoDeDispositivo pruebaInteligente;

	@Before

	public void setUp() throws IOException {

		parser = new Parser();
		listaDeClientes = parser.parsear(Cliente.class,"src/test/java/testParser/cliente.json");
		cliente = listaDeClientes.get(0);
		pruebaInteligente = new DispositivoInteligente();


	}

	@Test
	public void nombre() 			 { Assert.assertEquals("Eco Tostadora", cliente.getPrimerDispositivo().getNombre()); }
	@Test
	public void kWh()	 			 { Assert.assertEquals(Long.valueOf(1), cliente.getPrimerDispositivo().getkWh());}
	@Test
	public void encendidoTrue()  	 { Assert.assertEquals(true,cliente.getPrimerDispositivo().isEncendido());}
	@Test
	public void tipoDeDispositivo()  { Assert.assertEquals(pruebaInteligente.getClass(),cliente.getPrimerDispositivo().getTipoDeDispositivo().getClass());}

}