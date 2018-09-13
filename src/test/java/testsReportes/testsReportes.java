package testsReportes;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dispositivosConcretos.DispositivoConcreto;
import testsCliente.ClasesParaTestearCliente;
import transformador.Transformador;
import usuario.Cliente;
import zona.Zona;

public class testsReportes {
	
	Cliente cliente1;
	ArrayList<DispositivoConcreto> dispositivos1 = new ArrayList<DispositivoConcreto>();
	
	Cliente cliente2;
	ArrayList<DispositivoConcreto> dispositivos2 = new ArrayList<DispositivoConcreto>();
	
	@Before
	public void inicializarCliente() {
		cliente1 = ClasesParaTestearCliente.clienteEstandar();
		dispositivos1 = ClasesParaTestearCliente.cincoDispositivosConcretos();
		//5 heladeras, 4 prendidas hace un mes y ahora apagada
		cliente1.setDispositivos(dispositivos1);
		
		cliente2 = ClasesParaTestearCliente.clienteEstandar();
		dispositivos2 = ClasesParaTestearCliente.cincoDispositivosConcretos();
		//5 heladeras, 4 prendidas hace un mes y ahora apagada
		cliente2.setDispositivos(dispositivos2);
		
	}

	@Test
	public void testConsumoHogarPeriodo() {
		
		//Cliente cliente = ClasesParaTestearCliente.clienteEstandar();
		//ArrayList<DispositivoConcreto> dispositivos = ClasesParaTestearCliente.cincoDispositivosConcretos();
		//5 heladeras, prendidas hace un mes y una ahora apagada
		//cliente.setDispositivos(dispositivos);
		
		/*DispositivoConcreto he = dispositivos.get(0);
		DispositivoConcreto he2 = dispositivos.get(1);
		DispositivoConcreto he3 = dispositivos.get(2);
		DispositivoConcreto he4 = dispositivos.get(3);
		DispositivoConcreto he5 = dispositivos.get(4);
		double consumoHe = he.calcularConsumoPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now());
		double consumoHe2 = he2.calcularConsumoPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now());
		double consumoHe3 = he3.calcularConsumoPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now());
		double consumoHe4 = he4.calcularConsumoPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now());
		double consumoHe5 = he5.calcularConsumoPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now());
		System.out.print(consumoHe);
		System.out.print(consumoHe2);
		System.out.print(consumoHe3);
		System.out.print(consumoHe4);
		System.out.print(consumoHe5);*/
		
		//el consumo mensual es 54
		assertEquals(270, cliente1.consumoHogarPeriodo(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now()), 1);
	}
	
	@Test
	public void testConsumoPromedioDispositivo() {
		DispositivoConcreto elPrimerDispositivo = dispositivos1.get(0);
		assertEquals(0.075, elPrimerDispositivo.consumoPromedioPorHora(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now()), 0.1);
	}
	
	@Test
	public void consumoPromedioTransformador() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		Zona zona1 = new Zona();
		Transformador transformador = new Transformador(clientes, "Transformador1", zona1, (float) 100, (float) 200);
		assertEquals(540, transformador.consumoPromedio(LocalDateTime.now().minus(1, ChronoUnit.MONTHS), LocalDateTime.now()), 1);
		
		
	}
}