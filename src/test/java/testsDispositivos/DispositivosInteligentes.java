package testsDispositivos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import dispositivo.DispositivoInteligente;
import org.junit.Test;

import mock.EncendidoMock;

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

	/* HAY QUE CAMBIAR ESTOS TEST PORQUE GETTIPODEDISPOSITIVO NO ESTA MAS
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
	*/

}
