package testsCliente;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.Encendido;
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
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestsSimplex {
	
	@Test
	public void testSimplexAriel() {
		
		//-----ARIEL-----//
		
		//Dispositivos de Ariel//
				
		ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
				
		DispositivoInteligente tvBase = new DispositivoInteligente("tvBase", new Encendido(), 90, 360);
		Televisor tv = new Televisor(tvBase, TipoPantalla.LED, 40);
				
		DispositivoInteligente lamparaBase = new DispositivoInteligente("lamparaBase", new Encendido(), 90, 360);
		Lampara lampara = new Lampara(lamparaBase, false, 11);
				
		DispositivoEstandar lavarropasBase = new DispositivoEstandar("lavarropasBase", 6, 30);
		Lavarropas lavarropas = new Lavarropas(lavarropasBase, false, false, 5);
				
		DispositivoInteligente pcBase = new DispositivoInteligente("pcBase", new Encendido(), 60, 360);
		PC pc = new PC(pcBase, true);
				
		DispositivoInteligente aireBase = new DispositivoInteligente("aireBase", new Encendido(), 90, 360);
		AireAcondicionado aireAcondicionado = new AireAcondicionado(aireBase, 2200);

		DispositivoEstandar microondasBase = new DispositivoEstandar("microondasBase", 3, 15);
		Microondas microondas = new Microondas(microondasBase, true);
				
		DispositivoEstandar planchaBase = new DispositivoEstandar("planchaBase", 30, 30);
		Plancha plancha = new Plancha(planchaBase, true);
				
		DispositivoInteligente ventiladorBase = new DispositivoInteligente("ventiladorBase", new Encendido(), 120, 360);
		Ventilador ventilador = new Ventilador(ventiladorBase, true);
				
			dispositivos.add(tv);
			dispositivos.add(lampara);
			dispositivos.add(lavarropas);
			dispositivos.add(pc);
			dispositivos.add(aireAcondicionado);
			dispositivos.add(microondas);
			dispositivos.add(plancha);
			dispositivos.add(ventilador);
			
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
}
