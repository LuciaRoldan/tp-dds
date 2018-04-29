package testsUnitariosCliente;
import categorias.CategoriaR1;
import dispositivos.Dispositivo;
import dispositivos.DispositivoEstandar;
import usuario.Cliente;
import usuario.TipoDocumento;
import java.util.ArrayList;

public class ClienteEstandar{
	
		public ClienteEstandar(){}
		
		Dispositivo dispositivo1 = new Dispositivo("Dispositivo1", Long.valueOf(1), true, new DispositivoEstandar() );
		Dispositivo dispositivo2 = new Dispositivo("Dispositivo2", Long.valueOf(1), true, new DispositivoEstandar() );
		Dispositivo dispositivo3 = new Dispositivo("Dispositivo3", Long.valueOf(1), true, new DispositivoEstandar() );
		Dispositivo dispositivo4 = new Dispositivo("Dispositivo4", Long.valueOf(1), false, new DispositivoEstandar() );
		Dispositivo dispositivo5 = new Dispositivo("Dispositivo5", Long.valueOf(1), true, new DispositivoEstandar() );
		
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		
		//String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo
		
		public ArrayList<Dispositivo> dispositivos(){
			dispositivos = new ArrayList <Dispositivo>();
			
			dispositivos.add(dispositivo1);
			dispositivos.add(dispositivo2);
			dispositivos.add(dispositivo3);
			dispositivos.add(dispositivo4);
			dispositivos.add(dispositivo5);
				
			return dispositivos;
		}
		

		public Cliente generarse() {
		Cliente cliente = new Cliente("Juan Perez",
			"Calle Falsa 123",
			"01012001",
			"jperez",
			"123",
			TipoDocumento.DNI,
			12345678,
			12345678,
			new CategoriaR1(),
			this.dispositivos());
		
		return cliente;
		}
		
}