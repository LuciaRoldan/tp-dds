package testsDispositivos;

import dispositivos.Dispositivo;
import dispositivos.DispositivoInteligente;
import dispositivos.Apagado;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DispositivosInteligentes {

	Dispositivo dispositivo;
	
	@Before
	public void inicializar() {
		dispositivo = new Dispositivo("Dispositivos 1", Long.valueOf(5), true, new DispositivoInteligente(new Apagado()));
	}
	
	@Test
	public void testEncenderDIApagado() {
		dispositivo.encendete();
		assertTrue(dispositivo.estaEncendido());
	}
	
	@Test
	public void testApagarDIApagado() {
		dispositivo.apagate();
		assertTrue(dispositivo.estaApagado());
	}
	
	@Test
	public void testActivarAhorroDeEnergia() {
		dispositivo.activarAhorroDeEnergia();
		assertTrue(dispositivo.estaEncendido());
	}

}
