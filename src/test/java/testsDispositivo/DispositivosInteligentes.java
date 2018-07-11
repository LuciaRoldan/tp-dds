package testsDispositivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoInteligente;

import org.junit.Test;

public class DispositivosInteligentes {

	DispositivoInteligente dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
	DispositivoInteligente dispositivo;
	

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
		
		//dispositivoInteligente.getEstado().encendete(dispositivoInteligente.getTipoDeDispositivo());
		
		Long consumo = dispositivoInteligente.calcularConsumoPeriodo(hoy, manana);

		assertEquals(Long.valueOf(0), consumo);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime hace3horas = hoy.minus(3, ChronoUnit.HOURS);
		
		//dispositivoInteligente.agregarEstado(new EncendidoMock(hoy, manana));
		
		Long consumo = dispositivoInteligente.calcularConsumoUltimasNHoras(3L);
		
		//Long consum = hoy.until(manana, ChronoUnit.HOURS) * dispositivoInteligente.getkWh();
		
		assertEquals(Long.valueOf(30), consumo);
	}

}
