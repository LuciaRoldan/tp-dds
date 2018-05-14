package testsUnitariosCliente;

import java.util.ArrayList;

import categorias.CategoriaResidencial;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import usuario.Cliente;
import usuario.TipoDocumento;

public class ClasesParaTestear {
	public static Cliente clienteEstandar() {
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		Cliente cliente = new Cliente("Juan Perez",
				"Calle Falsa 123",
				"01012001",
				"jperez",
				"123",
				TipoDocumento.DNI,
				12345678,
				12345678,
				CategoriaResidencial.CATEGORIAR2,
				dispositivos);
				
		return cliente;			
	}
	
	public static ArrayList <Dispositivo> cincoDispositivos(){
		ArrayList<Dispositivo> dispositivos = new ArrayList <Dispositivo>();
		Dispositivo dispositivo1 = new Dispositivo("Dispositivo1", Long.valueOf(1), true, new DispositivoEstandar(1) );
		Dispositivo dispositivo2 = new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar(1) );
		Dispositivo dispositivo3 = new Dispositivo("Dispositivo3", Long.valueOf(1), true, new DispositivoEstandar(1) );
		Dispositivo dispositivo4 = new Dispositivo("Dispositivo4", Long.valueOf(1), false, new DispositivoEstandar(1) );
		Dispositivo dispositivo5 = new Dispositivo("Dispositivo5", Long.valueOf(1), true, new DispositivoEstandar(1) );
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		dispositivos.add(dispositivo3);
		dispositivos.add(dispositivo4);
		dispositivos.add(dispositivo5);
		return dispositivos;
	}
	
}
