package testsModulo;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.Before;
import org.junit.Test;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;
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
		
		dispositivo = new Modulo(dispositivoEstandar,new Encendido());
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
		
		Long consumo = dispositivo.calcularConsumoPeriodo(ayer, hoy);

		assertEquals(Long.valueOf(0), consumo);
	}
	
	@Test
	public void testConsumoEnUltimasTresHoras() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		Long consumo = dispositivo.calcularConsumoUltimasNHoras(24L);
	
		// 2,000*24 = 48,000
		assertEquals(Long.valueOf(48000), consumo);
		//me da 46000 osea que le esta errando por 1 hora

	}

}
