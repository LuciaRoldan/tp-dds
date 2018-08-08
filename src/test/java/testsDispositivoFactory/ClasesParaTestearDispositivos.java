package testsDispositivoFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.*;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;
import mock.EncendidoMock;
import dispositivo.DispositivoFactory;

public class ClasesParaTestearDispositivos {
	
	public static EstadoDispositivo unEstadoEncendido() {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
		
		return new EncendidoMock(ayer, hoy);
	}

	public static DispositivoInteligente unDispositivoInteligente() {
		
		EstadoDispositivo encendido = unEstadoEncendido();
		DispositivoInteligente dispositivo = new DispositivoInteligente("nombre", encendido, 200, 2000);
		
		return dispositivo;
	}
	
	public static DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar("Nombre loco", 200, 2000));
	}
	//Se deberian poder crear estos sin que no sean concretos?
	
	public static DispositivoConcreto unDispositivoConcreto() {
		DispositivoFactory factory = new DispositivoFactory();
		DispositivoConcreto dispositivo = factory.crearHeladeraSinFreezer();
		return dispositivo;
		
	}
}
