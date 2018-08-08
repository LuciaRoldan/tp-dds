package testsClienteFactory;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import categoria.CategoriaResidencial;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import dispositivosConcretos.Lampara;
import dispositivosConcretos.Lavarropas;
import dispositivosConcretos.Microondas;
import dispositivosConcretos.PC;
import dispositivosConcretos.Plancha;
import dispositivosConcretos.Televisor;
import dispositivosConcretos.Ventilador;
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
				factory.setNombre("tvBase");
				tv = factory.crearTelevisorLED(40);
				factory.setNombre("lavarropasBase");
				lavarropas = factory.crearLavarropasSemiAutomatico(false, 5);
				factory.setNombre("pcBase");
				pc = factory.crearPC();
				factory.setNombre("aireBase");
				aireAcondicionado = factory.crearAireAcondicionado(2200);
				factory.setNombre("microondasBase");
				microondas = factory.crearMicroondas();
				factory.setNombre("planchaBase");
				plancha = factory.crearPlancha();
				factory.setNombre("ventiladorBase");
				ventilador = factory.crearVentiladorDeTecho();
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
	
		Cliente ariel = new Cliente("Ariel Boghossian", "Cabildo 1099", "01012000", "aboghoss", 
				"hipopotamo", TipoDocumento.DNI, 18000999, 1500009999, CategoriaResidencial.CATEGORIAR3, dispositivos);
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
		
		Cliente ariel = new Cliente("Ariel Boghossian", "Cabildo 1099", "01012000", "aboghoss", 
				"hipopotamo", TipoDocumento.DNI, 18000999, 1500009999, CategoriaResidencial.CATEGORIAR3, dispositivos);
		
		ariel.ejecutarSimplex();
		
		//LocalDateTime hoy = LocalDateTime.now();
		//LocalDateTime ayer = hoy.minus(1, ChronoUnit.DAYS);
		
		//dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		//double consumo = dispositivo.calcularConsumoUltimasNHoras(24);
	
		// 2,000*24 = 48,000
		assertEquals(312, lavarropas.consumoCorriente(),0.1);
		
	}
}

