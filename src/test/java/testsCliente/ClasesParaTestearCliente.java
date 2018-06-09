package testsCliente;

import java.util.ArrayList;

import categoria.CategoriaResidencial;
import testsDispositivos.ClasesParaTestearDispositivos;
import usuario.Cliente;
import usuario.TipoDocumento;

public class ClasesParaTestearCliente {
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
		Dispositivo dispositivo1 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		Dispositivo dispositivo2 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		Dispositivo dispositivo3 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		Dispositivo dispositivo4 = ClasesParaTestearDispositivos.unDispositivoEstandar();
		Dispositivo dispositivo5 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		dispositivo1.encendete();
		dispositivo2.encendete();
		dispositivo3.encendete();
		dispositivo5.encendete();
		dispositivos.add(dispositivo1);
		dispositivos.add(dispositivo2);
		dispositivos.add(dispositivo3);
		dispositivos.add(dispositivo4);
		dispositivos.add(dispositivo5);
		return dispositivos;
	}
	
}
