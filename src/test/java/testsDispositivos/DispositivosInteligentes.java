package testsDispositivos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import org.junit.Test;

import mock.EncendidoMock;

public class DispositivosInteligentes {

	DispositivoInteligenteInterfaz dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
	DispositivoInteligenteInterfaz dispositivo;
	

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
		
		//dispositivoInteligente.getEstado().encendete(dispositivoInteligente.getTipoDeDispositivo());
		
		double consumo = dispositivoInteligente.calcularConsumoPeriodo(ayer, hoy);

		assertEquals(0, consumo,0.05);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime hace3horas = hoy.minus(3, ChronoUnit.HOURS);
		
		//dispositivoInteligente.agregarEstado(new EncendidoMock(hoy, manana));
		
		double consumo = dispositivoInteligente.calcularConsumoUltimasNHoras(3);
		
		//Long consum = hoy.until(manana, ChronoUnit.HOURS) * dispositivoInteligente.getkWh();
		
		assertEquals(30, consumo,0.05);
	}

}
