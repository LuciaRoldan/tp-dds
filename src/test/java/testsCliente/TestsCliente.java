package testsCliente;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import dispositivo.Dispositivo;
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestsCliente {
	ArrayList<Dispositivo> dispositivos;
	Cliente cliente;


	@Before

	public void setUp() throws Exception {
		
		cliente = ClasesParaTestearCliente.clienteEstandar();
		dispositivos = ClasesParaTestearCliente.cincoDispositivos();
		cliente.setDispositivos(dispositivos);
}


	@Test
	public void testGetCantidadDispositivos() {
		assertEquals(5, cliente.getCantidadDispositivos());
	}

	@Test
	public void testGetDispositivosEncendidos() {
		//sigue quedando feo porque queda hardcodeado pero oh well
		ArrayList<Dispositivo> dispositivosEncendidos = new ArrayList <Dispositivo>();
		dispositivosEncendidos.add(dispositivos.get(0));
		dispositivosEncendidos.add(dispositivos.get(1));
		dispositivosEncendidos.add(dispositivos.get(2));
		dispositivosEncendidos.add(dispositivos.get(4));
		
		assertEquals(dispositivosEncendidos, cliente.getDispositivosEncendidos());
	}

	@Test
	public void testGetSizeDispositivosEncendidos() {
		assertEquals(4, cliente.getCantidadDispositivosEncendidos());
	}

	@Test
	public void testGetSizeDispositivosApagados() {
		assertEquals(0, cliente.getCantidadDispositivosApagados());
	}

	@Test
	public void testGetPrimerDispositivo() {
		assertEquals(dispositivos.get(0), cliente.getPrimerDispositivo());
	}

	@Test
	public void testGetCategoriaResidencial() {
		assertEquals(CategoriaResidencial.CATEGORIAR2, cliente.getCategoriaResidencial());
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
		cliente.setCategoriaResidencial(CategoriaResidencial.CATEGORIAR5);
		assertEquals(CategoriaResidencial.CATEGORIAR5, cliente.getCategoriaResidencial());	
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
		otrosDispositivos.add(dispositivos.get(2));
		
		cliente.setDispositivos(otrosDispositivos);
		
		assertEquals(otrosDispositivos, cliente.getDispositivos());	
	}

	@Test
	public void testCalcularConsumoMensual() {
		assertEquals((double) 600000, cliente.calcularConsumoMensual());
	}

	@Test
	public void testRecategorizacion() {
		cliente.recategorizarse();
		assertEquals(CategoriaResidencial.CATEGORIAR9, cliente.getCategoriaResidencial());
	}

}
