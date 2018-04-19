package testsUnitariosCliente;

import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import dispositivos.DispositivoInteligente;
import org.junit.Test;
import usuario.Cliente;
import usuario.TipoDocumento;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSiElClienteTieneDosDispositivosPuedeTenerAmbosApagados {

	@Test 
	public void test() {
		
		CategoriaR1 r1 = new CategoriaR1();
		Dispositivo dispositivo1 = new Dispositivo("television",Long.valueOf(5000), false,new DispositivoInteligente());
		Dispositivo dispositivo2 =new Dispositivo("computadora", Long.valueOf(5000), false,new DispositivoEstandar());
		ArrayList<Dispositivo>dispositivos = new ArrayList<>();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		Cliente cliente = new Cliente();
		cliente.inicializarCliente("Ivana Mazzini", "Rawson 550",LocalDate.of(2018, 02, 03), "imazzini", "imazzini",TipoDocumento.DNI,39804507,546545, r1,dispositivos);
		
		assertEquals(2, cliente.cantidadDispositivosApagados());
	}
}
