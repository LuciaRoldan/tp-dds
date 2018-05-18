package testParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.NoSePudoAbrirElArchivoException;
import categorias.*;
import dispositivos.*;
import parser.*;
import usuario.*;


public class TestsParser {

	MiParser parser;
	List<Usuario> listaDeAdministradores;
	Administrador administrador;
	DateTimeFormatter formatter;
	List<Usuario> listaDeClientes;
	Cliente cliente;
	TipoDeDispositivo pruebaInteligente;
	Dispositivo dispositivo;

	@Before

	public void setUp() throws NoSePudoAbrirElArchivoException {

		parser = new MiParser();

		listaDeClientes = parser.parsearUsuario("src/test/java/testParser/cliente.json");
		cliente = (Cliente) listaDeClientes.get(0);

		listaDeAdministradores = parser.parsearUsuario("src/test/java/testParser/usuarios.json");
		administrador = (Administrador) listaDeAdministradores.get(1);
		formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		dispositivo = parser.parsearDispositivo("src/test/java/testParser/dispositivo.json");
		
		
	}
	

	// Cliente
	@Test
	public void clienteEsDeClaseCliente() {
		Assert.assertEquals(Cliente.class, cliente.getClass());
	}

	@Test
	public void coincidenLosCamposDeCliente() {
		Assert.assertEquals(CategoriaResidencial.CATEGORIAR5, cliente.getCategoriaResidencial());
		Assert.assertEquals("123321", cliente.getContrasena());	
		Assert.assertEquals(1234456, cliente.getDocumento());	
		Assert.assertEquals("Av.del libertador 2000", cliente.getDomicilio());
		Assert.assertEquals(LocalDate.parse("01/01/2001", formatter), cliente.getFechaDeAlta());
		Assert.assertEquals(TipoDeUsuario.CLIENTE, cliente.getTipoDeUsuario());
		Assert.assertEquals(TipoDocumento.DNI, cliente.getTipoDocumento());
		Assert.assertEquals("MatiasMorsa", cliente.getNombreYApellido());
		Assert.assertEquals("Matias21313", cliente.getNombreUsuario());
		Assert.assertEquals("Eco Tostadora", cliente.getPrimerDispositivo().getNombre());
	}

	// Administrador
	@Test
	public void administradorEsDeClaseAdministrador() {
		Assert.assertEquals(Administrador.class, administrador.getClass());
	}

	@Test
	public void coincidenLosCamposDeAdministrador() {
		Assert.assertEquals("MatiasMorsa", administrador.getNombreYApellido());
		Assert.assertEquals("Matias21313", administrador.getNombreUsuario());
		Assert.assertEquals("Av.del libertador 2000", administrador.getDomicilio());
		Assert.assertEquals("123321", administrador.getContrasena());
		Assert.assertEquals(LocalDate.parse("01/01/2001", formatter), administrador.getFechaDeAlta());
		Assert.assertEquals(1234, administrador.getNumeroDeIdentificacion());
		Assert.assertEquals(TipoDeUsuario.ADMINISTRADOR, administrador.getTipoDeUsuario());
	}

	// Dispositivo
	@Test
	public void coincidenLosCamposDeDispositivo() {
		Assert.assertEquals("Eco Tostadora", dispositivo.getNombre());
		Assert.assertEquals(Long.valueOf(1), dispositivo.getkWh());
		Assert.assertEquals(true, dispositivo.isEncendido());
		Assert.assertEquals(DispositivoInteligente.class, dispositivo.getTipoDeDispositivo().getClass());
	}
	
	@Test (expected = NoSePudoAbrirElArchivoException.class)
	public void noSePudoAbrirElArchivoException() {
		parser.parsearUsuario("~/Pictures/Wallpapers/Frank-best-tutor.jpg");
	}


}
