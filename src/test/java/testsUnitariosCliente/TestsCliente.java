package testsUnitariosCliente;

import categorias.CategoriaR1;
import categorias.CategoriaR5;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import org.junit.Before;
import org.junit.Test;
import usuario.Cliente;
import usuario.TipoDocumento;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestsCliente {

	ClienteEstandar clienteEstandar = new ClienteEstandar();
	Cliente cliente = clienteEstandar.generarse();
	ArrayList<Dispositivo> dispositivos = clienteEstandar.dispositivos();
	
	@Test
	public void testGetCantidadDispositivos() {
		assertEquals(5,cliente.getCantidadDispositivos());
	}

	@Test
	public void testGetDispositivosEncendidos() {
		//esto no me gusta nada pero no se me ocurre otra forma
		ArrayList<Dispositivo> dispositivosEncendidos = new ArrayList <Dispositivo>();
		dispositivosEncendidos.add(dispositivos.get(0));
		dispositivosEncendidos.add(dispositivos.get(1));
		dispositivosEncendidos.add(dispositivos.get(2));
		dispositivosEncendidos.add(dispositivos.get(4));
		
		assertEquals(dispositivosEncendidos, cliente.getDispositivosEncendidos());
	}

	@Test
	public void testGetSizeDispositivosEncendidos() {
		assertEquals(4,cliente.getCantidadDispositivosEncendidos());
	}

	@Test
	public void testGetSizeDispositivosApagados() {
		assertEquals(1,cliente.getCantidadDispositivosApagados());
	}

	@Test
	public void testGetPrimerDispositivo() {
		assertEquals(dispositivos.get(0), cliente.getPrimerDispositivo());
	}

	@Test
	public void testGetCategoriaResidencial() {
		assertEquals(CategoriaR1.class, cliente.getCategoriaResidencial().getClass());
	}

	@Test
	public void testGetTipoDocumento() {
		assertEquals(TipoDocumento.DNI, cliente.getTipoDocumento());
	}

	@Test
	public void testGetDispositivos() {
		assertEquals(dispositivos, cliente.getDispositivos());
	}

	@Test
	public void testGetAnyDispositivosEncendidos() {
		assertTrue(cliente.alMenosUnoEstaEncendido());
	}

	@Test
	public void testSetCategoriaResidencial() {
		cliente.setCategoriaResidencial(new CategoriaR5() );
		assertEquals(CategoriaR5.class, cliente.getCategoriaResidencial().getClass());	
	}


	@Test
	public void testSetTipoDocumento() {
		cliente.setTipoDocumento(TipoDocumento.LE );
		assertEquals(TipoDocumento.LE, cliente.getTipoDocumento());
	}


	@Test
	public void testSetDispositivos() {
		ArrayList<Dispositivo> otrosDispositivos;
		otrosDispositivos = new ArrayList <Dispositivo>();
		otrosDispositivos.add(dispositivos.get(0));
		otrosDispositivos.add(dispositivos.get(3));
		cliente.setDispositivos(otrosDispositivos);
		
		assertEquals(otrosDispositivos, cliente.getDispositivos());	
	}

	@Test
	public void testCalcularConsumoMensual() {
		assertEquals((double) 4, cliente.calcularConsumoMensual());
	}

	@Test
	public void testRecategorizacion() {
		cliente.recategorizarse();
		assertEquals(CategoriaR1.class, cliente.getCategoriaResidencial().getClass());
	}

}
