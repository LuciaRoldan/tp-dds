package testsDispositivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import dispositivo.DispositivoInteligente;
import dispositivosConcretos.DispositivoConcreto;

public class DispositivosInteligentes {

	DispositivoInteligente dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
	DispositivoInteligente dispositivo;
	
	DispositivoConcreto aire = ClasesParaTestearDispositivos.unDispositivoConcretoInteligente();
	

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
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		double consumo = aire.calcularConsumoPeriodo(ayer, hoy);

		assertEquals(37, consumo, 0.1);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		double consumo = aire.calcularConsumoUltimasNHoras(3);
		
		assertEquals(3.2, consumo,0.1);
	}

}

