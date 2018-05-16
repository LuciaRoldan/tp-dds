package testsDispositivos;

import dispositivos.Dispositivo;
import dispositivos.DispositivoInteligente;
import dispositivos.Apagado;
import static org.junit.Assert.*;

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
	
	//@Test Consumo

}
