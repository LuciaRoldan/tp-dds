package testsUnitariosCliente;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import dispositivos.DispositivoInteligente;
import usuario.Cliente;
import usuario.TipoDocumento;

public class TestSiElClienteTieneDosDispositivosPuedeTenerAmbosApagados {


	@Test
	public void test() {
		
		CategoriaResidencial r1 = CategoriaResidencial.CATEGORIAR1;
		Dispositivo dispositivo1 = new Dispositivo("television",Long.valueOf(5000), false,new DispositivoInteligente());
		Dispositivo dispositivo2 =new Dispositivo("computadora", Long.valueOf(5000), false,new DispositivoEstandar());
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		Cliente cliente = new Cliente("Ivana Mazzini", "Rawson 550","20180203", "imazzini", "imazzini",TipoDocumento.DNI,39804507,546545, r1,dispositivos);
		
		assertEquals(2, cliente.getCantidadDispositivosApagados());
	}

}
