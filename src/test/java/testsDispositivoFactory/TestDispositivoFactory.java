package testsDispositivoFactory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import dispositivo.DispositivoFactory;
import dispositivosConcretos.Lampara;
import dispositivosConcretos.Lavarropas;
import dispositivosConcretos.Microondas;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class TestDispositivoFactory {

	@Test
	public void testCrearLampara() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("Lampaita");
		assertEquals(Lampara.class, factory.crearLamparaComun(11).getClass());
	}
	
	@Test
	public void testVerificarCapacidadLavarropas() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("Lavarropas");
		Lavarropas lavarropas = factory.crearLavarropasAutomatico(true, 5);
		assertEquals(5, lavarropas.getCapacidad());
	}
	
	@Test
	public void testVerificarPotencia() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("Microondas");
		Microondas microondas = factory.crearMicroondas();
		assertEquals(0.64, microondas.getPotencia(), 0.1);
	}

	@Test(expected = DispositivoBaseInvalidoException.class)
	public void testVerificarExcepcion() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.crearMicroondas();
	}
}
