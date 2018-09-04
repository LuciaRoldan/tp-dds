package testsDispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.*;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;
import mock.EncendidoMock;
import dispositivo.DispositivoFactory;

public class ClasesParaTestearDispositivos {
	
	public static EstadoDispositivo unEstadoEncendido() {
		return new EncendidoMock(LocalDateTime.now().minus(30, ChronoUnit.DAYS), LocalDateTime.now());
	}

	public static DispositivoInteligente unDispositivoInteligente() {
		
		EstadoDispositivo encendido = unEstadoEncendido();
		DispositivoInteligente dispositivo = new DispositivoInteligente("nombre", encendido, 200, 2000);
		
		return dispositivo;
	}
	
	public static DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar("Nombre loco", 200, 2000, 40));
	}
	//Se deberian poder crear estos sin que no sean concretos?
	
	/*public static DispositivoConcreto unDispositivoConcreto() {
		
		DispositivoInteligente base = unDispositivoInteligente();
		DispositivoConcreto dispositivo = new Heladera(base, false);
		return dispositivo;
		
	}*/
	
	public static DispositivoConcreto unDispositivoConcreto() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("Heladera");
		DispositivoConcreto dispositivo = factory.crearHeladeraSinFreezer();
		return dispositivo;
		
	}
}
