package testsCliente;

import java.util.ArrayList;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoInteligente;
import testsDispositivo.ClasesParaTestearDispositivos;
import usuario.Cliente;
import usuario.TipoDocumento;

public class ClasesParaTestearCliente {

	public static Cliente clienteEstandar() {
		ArrayList<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
		Cliente cliente = new Cliente("Juan Perez",
				"Calle Falsa 123",
				"01012001",
				"jperez",
				"123",
				TipoDocumento.DNI,
				12345678,
				12345678,
				CategoriaResidencial.CATEGORIAR2,
				dispositivos,null);
				
		return cliente;			
	}
	
	public static ArrayList<DispositivoInteligente> cincoDispositivos(){
		ArrayList<DispositivoInteligente> dispositivos = new ArrayList<DispositivoInteligente>();
		DispositivoInteligente	dispositivo1 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		DispositivoInteligente	dispositivo2 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		DispositivoInteligente	dispositivo3 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		DispositivoInteligente  dispositivo4 = ClasesParaTestearDispositivos.unDispositivoInteligente();
		DispositivoInteligente  dispositivo5 = ClasesParaTestearDispositivos.unDispositivoInteligente();
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
