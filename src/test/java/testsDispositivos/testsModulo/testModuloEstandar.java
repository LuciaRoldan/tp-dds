package testsDispositivos.testsModulo;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.Before;
import org.junit.Test;
import dispositivo.DispositivoEstandar;
import dispositivo.Modulo;
import dispositivo.estados.Encendido;
import mock.EncendidoMock;
import testsDispositivos.ClasesParaTestearDispositivos;

public class testModuloEstandar {

	Modulo dispositivo;
	DispositivoEstandar dispositivoEstandar;
	

	@Before

	public void setUp() {
		DispositivoEstandar dispositivoEstandar = ClasesParaTestearDispositivos.unDispositivoEstandar();
		// DispositivoEstandar(2000L, "Microondas", 1L
		
		dispositivo = new Modulo(dispositivoEstandar,ClasesParaTestearDispositivos.unEstadoEncendido());
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

	@Test
	public void testConsumoEnPeriodo() {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		//dispositivoInteligente.getEstado().encendete(dispositivoInteligente.getTipoDeDispositivo());
		
		double consumo = dispositivo.calcularConsumoPeriodo(ayer, hoy);

		assertEquals(0, consumo,0.05);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		double consumo = dispositivo.calcularConsumoUltimasNHoras(24);
	
		// 2,000*24 = 48,000
		assertEquals(48000, consumo,0.05);
		//me da 46000 osea que le esta errando por 1 hora

	}

}
