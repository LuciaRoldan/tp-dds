package testsDispositivos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import dispositivos.ApagadoMock;
import dispositivos.Dispositivo;
import dispositivos.DispositivoInteligente;
import dispositivos.EncendidoMock;

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
		
		dispositivoInteligente.getEstado().encendete(dispositivoInteligente.getTipoDeDispositivo());
		
		Long consumo = dispositivoInteligente.getTipoDeDispositivo().calcularConsumoPeriodo(hoy, manana,
				dispositivoInteligente.getkWh());

		assertEquals(Long.valueOf(0), consumo);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime manana = hoy.plus(1, ChronoUnit.DAYS);
		
		dispositivoInteligente.getTipoDeDispositivo().agregarEstado(new EncendidoMock(hoy, manana));
		
		Long consumo = dispositivoInteligente.getTipoDeDispositivo().calcularConsumoUltimasNHoras(24, dispositivoInteligente.getkWh());
		
		//Long consum = hoy.until(manana, ChronoUnit.HOURS) * dispositivoInteligente.getkWh();
		
		assertEquals(Long.valueOf(0), consumo);
	}
	

}
