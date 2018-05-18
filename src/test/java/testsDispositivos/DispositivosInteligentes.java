package testsDispositivos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import dispositivos.Dispositivo;

public class DispositivosInteligentes {

	Dispositivo dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
	Dispositivo dispositivo;
	
//	@Mock private Estado estado;
//
//	private void mockearEstado() {
//		LocalDateTime inicio = LocalDateTime.of(2018, 05, 01, 12, 42);
//		LocalDateTime fin = LocalDateTime.now();
//		when(estado.calcularConsumo(Long.valueOf(500))).thenReturn(1000);
//	}
	

	@Test
	public void testEncenderDIApagado() {
		dispositivoInteligente.encendete();
		assertTrue(dispositivoInteligente.estaEncendido());
	}

	@Test
	public void testApagarDIApagado() {
		dispositivoInteligente.apagate();
		assertTrue(dispositivoInteligente.estaApagado());
	}

	@Test
	public void testActivarAhorroDeEnergia() {
		dispositivoInteligente.activarAhorroDeEnergia();
		assertTrue(dispositivoInteligente.estaEncendido());
	}

	@Test
	public void testEncenderDispositivo() {
		dispositivoInteligente.encendete();
		assertEquals(true, dispositivoInteligente.estaEncendido());
	}

	@Test
	public void testAhorroDeEnergiaYEncendido() {
		dispositivoInteligente.activarAhorroDeEnergia();
		assertEquals(true, dispositivoInteligente.estaEncendido());

	}

	@Test
	public void testConsumoEnPeriodo() {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime manana = hoy.plus(1, ChronoUnit.DAYS);

		Long consumo = dispositivoInteligente.getTipoDeDispositivo().calcularConsumoPeriodo(hoy, manana,
				dispositivoInteligente.getkWh());

		assertEquals(Long.valueOf(0), consumo);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		
		dispositivoInteligente.encendete();	
		
		assertTrue(dispositivoInteligente.estaEncendido());
		
		Long consumo = dispositivoInteligente.getTipoDeDispositivo().calcularConsumoUltimasNHoras(8, dispositivoInteligente.getkWh());
		
		assertEquals(Long.valueOf(0), consumo);
	}
	

}
