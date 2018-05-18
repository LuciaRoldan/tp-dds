package testsDispositivos;

import dispositivos.Dispositivo;
import dispositivos.DispositivoInteligente;
import dispositivos.AhorroDeEnergia;
import dispositivos.Apagado;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

public class DispositivosInteligentes {

	Dispositivo dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
	Dispositivo dispositivo;

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
				Long.valueOf(1));

		assertEquals(Long.valueOf(1), consumo);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		Long consumo = dispositivoInteligente.getTipoDeDispositivo().calcularConsumoUltimasNHoras(3, Long.valueOf(1));
		
		assertEquals(Long.valueOf(1), consumo);
	}

}
