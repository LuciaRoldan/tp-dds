package testsDispositivo;

import static org.junit.Assert.*;

import org.junit.Test;

import dispositivo.DispositivoInteligente;
import dispositivo.estados.AhorroDeEnergia;

public class testsEstados {

	@Test
	public void CrearAhorroDeEnergia() {
		DispositivoInteligente dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
		dispositivoInteligente.activarAhorroDeEnergia();
		assertEquals(dispositivoInteligente.getEstado().getClass(), AhorroDeEnergia.class);
	}
	
	@Test
	public void PasarDeAhorroDeEnergiaAEncendido() {
		DispositivoInteligente dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
		dispositivoInteligente.activarAhorroDeEnergia();
		dispositivoInteligente.encendete();
		assertTrue(dispositivoInteligente.estaEncendido());
	}
	
	@Test
	public void SiEstaEncendidoNoEstaApagado() {
		DispositivoInteligente dispositivoInteligente = ClasesParaTestearDispositivos.unDispositivoInteligente();
		dispositivoInteligente.encendete();
		assertFalse(dispositivoInteligente.estaApagado());
	}

}
