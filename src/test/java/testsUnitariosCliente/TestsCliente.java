package testsUnitariosCliente;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestsCliente {
	ArrayList<Dispositivo> dispositivos;
	Cliente cliente;


	@Before

	public void setUp() throws Exception {
		
		cliente = ClasesParaTestear.clienteEstandar();
		dispositivos = ClasesParaTestear.cincoDispositivos();
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
		
		assertEquals(dispositivosEncendidos,cliente.getDispositivosInteligentesEncendidos());
	}

	@Test
	public void testGetSizeDispositivosEncendidos() {
		assertEquals(0, cliente.getCantidadDispositivosInteligentesEncendidos());
	}

	@Test
	public void testGetSizeDispositivosApagados() {
		assertEquals(0, cliente.getCantidadDispositivosInteligentesApagados());
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
		assertFalse(cliente.alMenosUnoEstaEncendido());
	}

	@Test
	public void testSetCategoriaResidencial() {
		cliente.setCategoriaResidencial2(CategoriaResidencial.CATEGORIAR5);
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
		assertEquals((double) 4, cliente.calcularConsumoMensual());
	}

	@Test
	public void testRecategorizacion() {
		cliente.recategorizarse();
		assertEquals(CategoriaResidencial.CATEGORIAR1, cliente.getCategoriaResidencial());
	}

}
