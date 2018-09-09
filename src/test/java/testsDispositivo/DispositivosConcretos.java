package testsDispositivo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivosConcretos.DispositivoConcreto;
import testsDispositivo.ClasesParaTestearDispositivos;

import org.junit.Test;


public class DispositivosConcretos {

	 DispositivoConcreto dispositivo = new ClasesParaTestearDispositivos().heladeraConFactory();
	

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
	public void testEncenderDispositivo() {
		dispositivo.encendete();
		assertEquals(true, dispositivo.estaEncendido());
	}

	@Test
	public void testAhorroDeEnergiaYEncendido() {
		dispositivo.activarAhorroDeEnergia();
		assertEquals(true, dispositivo.estaEncendido());

	}	
	
	@Test
	public void potenciaDeHeladeraSinFreezer() {
		double potencia = dispositivo.getPotencia();
		assertEquals(0.075, potencia,0.01);
		}

	@Test //esta re loco debuguea verde y prueba en rojo
	public void testConsumoEnPeriodo() {

		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		double consumo = dispositivo.calcularConsumoPeriodo(ayer, hoy);
		//0.075*24=1.8
		assertEquals(1.8, consumo,0.1);
	}

	@Test
	public void testConsumoEnUltimasTresHoras() {
		double consumo = dispositivo.calcularConsumoUltimasNHoras(3);
		//0.075*3=0.225
		assertEquals(0.225, consumo,0.2);
	}
	
}
