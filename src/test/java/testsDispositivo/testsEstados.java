package testsDispositivo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import dispositivo.DispositivoInteligente;
import dispositivo.estados.AhorroDeEnergia;
import dispositivo.estados.Encendido;
import dispositivo.estados.EstadoDispositivo;
import mock.EncendidoMock;

public class testsEstados {

	LocalDateTime ahora = LocalDateTime.now();
	
	LocalDateTime haceUnAnio = ahora.minus(1, ChronoUnit.YEARS);
	LocalDateTime haceUnMes = ahora.minus(1, ChronoUnit.MONTHS);
	LocalDateTime ayer = ahora.minus(1, ChronoUnit.DAYS);
	
	LocalDateTime maniana = ahora.plus(1,ChronoUnit.DAYS);
	LocalDateTime enUnMes = ahora.plus(1, ChronoUnit.MONTHS);
	LocalDateTime enUnAnio = ahora.plus(1, ChronoUnit.YEARS);
	
	EncendidoMock encendidoSinFin = new EncendidoMock(haceUnMes, null);
	
	
	EstadoDispositivo encendido = new ClasesParaTestearDispositivos().unEstadoEncendido();
	//el intervalo de encendido: [haceUnMes ; maniana]
	
	

	@Test
	public void CrearAhorroDeEnergia() {
		DispositivoInteligente dispositivoInteligente = new ClasesParaTestearDispositivos().unDispositivoInteligente();
		dispositivoInteligente.activarAhorroDeEnergia();
		assertEquals(dispositivoInteligente.getEstado().getClass(), AhorroDeEnergia.class);
		}
	
	@Test
	public void PasarDeAhorroDeEnergiaAEncendido() {
		DispositivoInteligente dispositivoInteligente = new ClasesParaTestearDispositivos().unDispositivoInteligente();
		dispositivoInteligente.activarAhorroDeEnergia();
		dispositivoInteligente.encendete();
		assertTrue(dispositivoInteligente.estaEncendido());
	}
	
	@Test
	public void SiEstaEncendidoNoEstaApagado() {
		DispositivoInteligente dispositivoInteligente = new ClasesParaTestearDispositivos().unDispositivoInteligente();
		dispositivoInteligente.encendete();
		assertFalse(dispositivoInteligente.estaApagado());
	}
	
	@Test
	public void IncluyeA() {
		assertTrue(encendido.incluyeA(ayer));
		assertFalse(encendido.incluyeA(haceUnAnio));
		assertFalse(encendido.incluyeA(enUnMes));
	}
	
	@Test
	public void tiempoEnHoras(){
		double tiempoEsperado = haceUnMes.until(maniana, ChronoUnit.HOURS);
		double resultado = encendido.tiempoEnHoras();
		assertEquals(tiempoEsperado,resultado,0.0001);
	}
	
	@Test
	public void elTiempoEnHorasDeUnEstadoSinFin() {
		double tiempoEsperado = (double)haceUnMes.until(ahora, ChronoUnit.HOURS);
		double resultado = (double)encendidoSinFin.tiempoEnHoras();
		assertEquals(tiempoEsperado,resultado,0.0001);
	}
	
	@Test
	public void xd() {
		assertEquals(ChronoUnit.HOURS.between(haceUnMes, haceUnMes.plus(1, ChronoUnit.DAYS) )
				, haceUnMes.until(haceUnMes.plus(1, ChronoUnit.DAYS),ChronoUnit.HOURS));

	}
		
	@Test
	public void tiempoEnHorasEnIntervalo(){
		assertEquals(24,encendido.tiempoEnHorasEnIntervalo(ayer,ahora) ,0);
		assertEquals(24,encendido.tiempoEnHorasEnIntervalo(ahora,enUnAnio),0);
		assertEquals(1,encendido.tiempoEnHorasEnIntervalo(ahora.minus(1,ChronoUnit.HOURS), ahora),0 );
		assertEquals(24,encendido.tiempoEnHorasEnIntervalo(haceUnMes, haceUnMes.plus(1, ChronoUnit.DAYS) ),0.05 );
		assertEquals(0,encendido.tiempoEnHorasEnIntervalo(enUnMes,enUnAnio),0);
		assertEquals(encendido.tiempoEnHoras(),encendido.tiempoEnHorasEnIntervalo(haceUnAnio, enUnAnio),0);
	}
	
	@Test
	public void tiempoEnHorasEnIntervaloSinFin(){
		assertEquals(null,encendidoSinFin.getFin());
		assertEquals(24,encendidoSinFin.tiempoEnHorasEnIntervalo(ayer,ahora) ,0);
		assertEquals(24,encendidoSinFin.tiempoEnHorasEnIntervalo(ayer,enUnAnio) ,0);
		assertEquals(24,encendidoSinFin.tiempoEnHorasEnIntervalo(haceUnAnio,haceUnMes.plus(1,ChronoUnit.DAYS)) ,0);
		}

}
