package testsUnitariosCliente;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestsCliente {

	ArrayList<Dispositivo> dispositivos;
	Cliente cliente;
	
	CategoriaResidencial r1;

	Dispositivo dispositivo1;
	Dispositivo dispositivo2;
	Dispositivo dispositivo3;
	Dispositivo dispositivo4;
	Dispositivo dispositivo5;

	@Before

	public void setUp() throws Exception {
		
		r1 = CategoriaResidencial.CATEGORIAR1;
		
		//                              String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo
		dispositivo1 = new Dispositivo("Dispositivo1", Long.valueOf(1), true, new DispositivoEstandar() );
		dispositivo2 = new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar() );
		dispositivo3 = new Dispositivo("Dispositivo3", Long.valueOf(1), true, new DispositivoEstandar() );
		dispositivo4 = new Dispositivo("Dispositivo4", Long.valueOf(1), false, new DispositivoEstandar() );
		dispositivo5 = new Dispositivo("Dispositivo5", Long.valueOf(1), true, new DispositivoEstandar() );
		
		dispositivos = new ArrayList <Dispositivo>();
		
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		dispositivos.add(dispositivo3);
		dispositivos.add(dispositivo4);
		dispositivos.add(dispositivo5);
		

		cliente = new Cliente("Juan Perez",
		"Calle Falsa 123",
		"01012001",
		"jperez",
		"123",
		TipoDocumento.DNI,
		12345678,
		12345678,
		CategoriaResidencial.CATEGORIAR2,
		dispositivos);
	}

	@Test
	public void testGetCantidadDispositivos() {
		assertEquals(5,cliente.getCantidadDispositivos());
	}

	@Test
	public void testGetDispositivosEncendidos() {
		ArrayList<Dispositivo> dispositivosEncendidos;
		dispositivosEncendidos = new ArrayList <Dispositivo>();
		dispositivosEncendidos.add(dispositivo1);
		dispositivosEncendidos.add(dispositivo2);
		dispositivosEncendidos.add(dispositivo3);
		dispositivosEncendidos.add(dispositivo5);
		
		assertEquals(dispositivosEncendidos,cliente.getDispositivosEncendidos());
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
		assertEquals(dispositivo1, cliente.getPrimerDispositivo());
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
		otrosDispositivos.add(dispositivo1);
		otrosDispositivos.add(dispositivo3);
		
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
