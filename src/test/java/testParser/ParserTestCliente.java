package testParser;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import categorias.CategoriaResidencial;
import parser.MiParser;
import usuario.Cliente;
import usuario.TipoDocumento;
import usuario.Usuario;

public class ParserTestCliente {

	MiParser parser;
	List<Usuario> listaDeClientes;
	Cliente cliente;

	@Before

	public void setUp() throws IOException {

		parser = new MiParser();
		listaDeClientes = parser.parsearUsuario("src/test/java/testParser/cliente.json");
		cliente = (Cliente) listaDeClientes.get(0);
	}

	@Test
	public void categoriaResidencial() {
		Assert.assertEquals(CategoriaResidencial.CATEGORIAR5, cliente.getCategoriaResidencial());
	}

	@Test
	public void contrasenia() {
		Assert.assertEquals("123321", cliente.getContrasena());
	}

	@Test
	public void dispositivo() {
		Assert.assertEquals("Eco Tostadora", cliente.getPrimerDispositivo().getNombre());
	}

	@Test
	public void domicilio() {
		Assert.assertEquals("Av.del libertador 2000", cliente.getDomicilio());
	}

	@Test
	public void nombreYapellido() {
		Assert.assertEquals("MatiasMorsa", cliente.getNombreYApellido());
	}

	@Test
	public void numeroDocumente() {
		Assert.assertEquals(1234456, cliente.getDocumento());
	}

	@Test
	public void nombreUsuario() {
		Assert.assertEquals("Matias21313", cliente.getNombreUsuario());
	}

	@Test
	public void telefono() {
		Assert.assertEquals(44444444, cliente.getTelefono());
	}

	@Test
	public void clase() {
		Cliente clientePrueba = new Cliente();
		Assert.assertEquals(clientePrueba.getClass(), cliente.getClass());
	}

	@Test
	public void tipoDocumento() {
		TipoDocumento documento = cliente.getTipoDocumento();
		Assert.assertEquals(TipoDocumento.DNI, documento);
	}
}
