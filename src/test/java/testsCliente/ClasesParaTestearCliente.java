package testsCliente;

import java.util.ArrayList;

import categoria.CategoriaResidencial;
import dispositivosConcretos.DispositivoConcreto;
import testsDispositivo.ClasesParaTestearDispositivos;
import usuario.Cliente;
import usuario.TipoDocumento;

public class ClasesParaTestearCliente {

	public static Cliente clienteEstandar() {
		ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
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

	public  static ArrayList<DispositivoConcreto> cincoDispositivosConcretos(){
		ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
		DispositivoConcreto	dispositivo1 = ClasesParaTestearDispositivos.heladeraConFactory();
		DispositivoConcreto	dispositivo2 = ClasesParaTestearDispositivos.heladeraConFactory();
		DispositivoConcreto	dispositivo3 = ClasesParaTestearDispositivos.heladeraConFactory();
		DispositivoConcreto dispositivo4 = ClasesParaTestearDispositivos.heladeraConFactory();
		DispositivoConcreto dispositivo5 = ClasesParaTestearDispositivos.heladeraConFactory();
		dispositivo1.encendete();
		dispositivo2.encendete();
		dispositivo3.encendete();
		dispositivo4.apagate();
		dispositivo5.encendete();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		dispositivos.add(dispositivo3);
		dispositivos.add(dispositivo4);
		dispositivos.add(dispositivo5);
		return dispositivos;
	}
	
}
