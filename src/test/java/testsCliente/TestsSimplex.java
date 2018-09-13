package testsCliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import dispositivosConcretos.Lampara;
import dispositivosConcretos.Lavarropas;
import dispositivosConcretos.Microondas;
import dispositivosConcretos.PC;
import dispositivosConcretos.Plancha;
import dispositivosConcretos.Televisor;
import dispositivosConcretos.TipoPantalla;
import dispositivosConcretos.Ventilador;
import mock.EncendidoMock;
import testsDispositivo.ClasesParaTestearDispositivos;
import usuario.Cliente;
import usuario.TipoDocumento;
import dispositivo.DispositivoFactory;

public class TestsSimplex {
	
			//-----ARIEL-----//
	
			//Dispositivos de Ariel//
	
			DispositivoFactory factory = new DispositivoFactory();
					
			ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
			Televisor tv;	
			Lampara lampara;
			Lavarropas lavarropas;
			PC pc;
			AireAcondicionado aireAcondicionado;
			Microondas microondas;
			Plancha plancha;
			Ventilador ventilador;
			
	@Before		
	public void antesQueNada() {
		
			EstadoDispositivo encendido = ClasesParaTestearDispositivos.unEstadoEncendido();		
		
			factory.setNombre("tvBase");
			tv = factory.crearTelevisorLED(40);
			tv.setEstado(encendido);
			
			factory.setNombre("lamparaBase");
			lampara = factory.crearLamparaComun(11);
			lampara.setEstado(encendido);
			
			factory.setNombre("lavarropasBase");
			factory.setHorasUsoMensuales(30);
			lavarropas = factory.crearLavarropasSemiAutomatico(false, 5);
			
			factory.setNombre("pcBase");
			factory.setHorasUsoMensuales(20);
			pc = factory.crearPC();
			
			factory.setNombre("aireBase");
			aireAcondicionado = factory.crearAireAcondicionado(2200);
			aireAcondicionado.setEstado(encendido);
			
			factory.setNombre("microondasBase");
			factory.setHorasUsoMensuales(5);
			microondas = factory.crearMicroondas();
			
			factory.setNombre("planchaBase");
			factory.setHorasUsoMensuales(15);
			plancha = factory.crearPlancha();
			
			factory.setNombre("ventiladorBase");
			ventilador = factory.crearVentiladorDeTecho();
			ventilador.setEstado(encendido);
				
			dispositivos.add(tv);
			dispositivos.add(lampara);
			dispositivos.add(lavarropas);
			dispositivos.add(pc);			
			dispositivos.add(aireAcondicionado);
			dispositivos.add(microondas);
			dispositivos.add(plancha);
			dispositivos.add(ventilador);
	}
			
	
	@Test
	public void testSimplexAriel() {

		ariel.configuracionOptima();
		
		//Checkeado con http://www.phpsimplex.com/simplex
		assertEquals((double) 360, tv.getConsumoIdeal(), 0);
		assertEquals((double) 360, lampara.getConsumoIdeal(), 0);
		assertEquals((double) 30, lavarropas.getConsumoIdeal(), 0);
		assertEquals((double) 360, pc.getConsumoIdeal(), 0);
		assertEquals((double) 360, aireAcondicionado.getConsumoIdeal(), 0);
		assertEquals((double) 15, microondas.getConsumoIdeal(), 0);
		assertEquals((double) 30, plancha.getConsumoIdeal(), 0);
		assertEquals((double) 360, ventilador.getConsumoIdeal(), 0);
	}
	
	
	@Test
	public void testEjecutarSimplexAriel() {
		
		Cliente ariel = new Cliente("Ariel Boghossian", "Cabildo 1099", LocalDate.of(2000, 01, 01), "aboghoss", 
				"hipopotamo", TipoDocumento.DNI, 18000999, 1500009999, CategoriaResidencial.CATEGORIAR3, dispositivos, (float) 0, (float) 0);
		
		ariel.ejecutarSimplex();
		
		//LocalDateTime hoy = LocalDateTime.now();
		//LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		//dispositivo.agregarEstado(new EncendidoMock(ayer);
		
		
		
		//anda
		//double consumoUltimasN = lampara.calcularConsumoUltimasNHoras(24);
		//assertEquals(consumoUltimasN, 0,264);
		
		//lampara.apagate();
		double consumoMensual = lampara.consumoMensual();
		//assertEquals(7.92, consumoMensual, 0.1);
		
		//0.011potencia*24horasXdia*DiaDelMesEnElQueEstoy
		double consumoCorriente = lampara.consumoCorriente();
		//assertEquals(0.4235, consumoCorriente, 0.1);
		
		
		//El Assert posta.

		double consumoCorrienteTV = tv.consumoCorriente();
		//assertEquals(200, consumoCorrienteTV, 0.1);
		assertTrue(tv.estaApagado());

		
	}
}

