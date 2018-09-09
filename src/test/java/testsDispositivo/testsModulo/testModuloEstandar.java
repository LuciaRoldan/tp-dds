package testsDispositivo.testsModulo;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.Before;
import org.junit.Test;
import dispositivo.DispositivoEstandar;
import dispositivo.Modulo;
import dispositivo.estados.Encendido;
import mock.EncendidoMock;
import testsDispositivo.ClasesParaTestearDispositivos;

public class testModuloEstandar {

	Modulo dispositivo;
	DispositivoEstandar dispositivoEstandar;
	

	@Before

	public void setUp() {
		DispositivoEstandar dispositivoEstandar = new  ClasesParaTestearDispositivos().unDispositivoEstandar();
		// DispositivoEstandar(2000L, "Microondas", 1L
		
		dispositivo = new Modulo(dispositivoEstandar,new ClasesParaTestearDispositivos().unEstadoEncendido());
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
	
	@Test //no puede calcular mas por no ser dispositivo concreto y no tener la potencia
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		double consumo = dispositivo.calcularConsumoUltimasNHoras(24);
	
		// 2,000*24 = 48,000
		assertEquals(0, consumo,0.05);

	}

}
