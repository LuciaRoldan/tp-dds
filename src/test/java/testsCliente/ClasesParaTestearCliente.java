package testsCliente;

import java.time.LocalDate;
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
				LocalDate.of(2001,01,01),
				"jperez",
				"123",
				TipoDocumento.DNI,
				12345678,
				12345678,
				CategoriaResidencial.CATEGORIAR2,
				dispositivos,
				(float) 0,
				(float) 0);
				
		return cliente;			
	}

	public  static ArrayList<DispositivoConcreto> cincoDispositivosConcretos(){
		ArrayList<DispositivoConcreto> dispositivos = new ArrayList<DispositivoConcreto>();
		DispositivoConcreto	dispositivo1 = new ClasesParaTestearDispositivos().heladeraConFactory();
		DispositivoConcreto	dispositivo2 = new ClasesParaTestearDispositivos().heladeraConFactory();
		DispositivoConcreto	dispositivo3 = new ClasesParaTestearDispositivos().heladeraConFactory();
		DispositivoConcreto dispositivo4 = new ClasesParaTestearDispositivos().heladeraConFactory();
		DispositivoConcreto dispositivo5 = new ClasesParaTestearDispositivos().heladeraConFactory();
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
