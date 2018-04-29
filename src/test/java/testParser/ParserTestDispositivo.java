package testParser;

import dispositivos.DispositivoInteligente;
import dispositivos.TipoDeDispositivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.MiParser;
import usuario.Cliente;
import usuario.Usuario;

import java.io.IOException;
import java.util.List;

public class ParserTestDispositivo {

	MiParser parser;
	List<Usuario> listaDeClientes;
	Cliente cliente;
	TipoDeDispositivo pruebaInteligente;

	@Before

	public void setUp() throws IOException {

		parser = new MiParser();
		listaDeClientes = parser.parsearUsuario("src/test/java/testParser/cliente.json");
		cliente = (Cliente) listaDeClientes.get(0);
		pruebaInteligente = new DispositivoInteligente();


	}

	@Test
	public void nombre()			 { Assert.assertEquals("Eco Tostadora", cliente.getPrimerDispositivo().getNombre()); }
	@Test
	public void kWh()	 			 { Assert.assertEquals(Long.valueOf(1), cliente.getPrimerDispositivo().getkWh());}
	@Test
	public void encendidoTrue()  	 { Assert.assertEquals(true,cliente.getPrimerDispositivo().isEncendido());}
	@Test
	public void tipoDeDispositivo()  { Assert.assertEquals(pruebaInteligente.getClass(),cliente.getPrimerDispositivo().getTipoDeDispositivo().getClass());}

}