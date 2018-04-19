package testsUnitariosCliente;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import dispositivos.DispositivoInteligente;
import usuario.TipoDocumento;
import usuario.Cliente;
import java.util.ArrayList;
import java.time.LocalDate;

public class TestSiElClienteTieneDosDispositivosPuedeTenerAmbosApagados {

	@Test 
	public void test() {
		
		CategoriaR1 r1 = new CategoriaR1();
		Dispositivo dispositivo1 = new Dispositivo("television", 5000, false,new DispositivoInteligente());
		Dispositivo dispositivo2 =new Dispositivo("computadora", 4500, false,new DispositivoEstandar());
		ArrayList<Dispositivo>dispositivos = new ArrayList<>();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		Cliente cliente = new Cliente("Ivana Mazzini", "Rawson 550",LocalDate.of(2018, 02, 03), "imazzini", "imazzini",TipoDocumento.DNI,39804507,546545, r1,dispositivos);
		
		assertEquals(2, cliente.cantidadDispositivosApagados());
	}
}
