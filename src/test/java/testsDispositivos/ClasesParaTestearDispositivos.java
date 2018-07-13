package testsDispositivos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.Apagado;
import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;
import dispositivosConcretos.Heladera;
import mock.EncendidoMock;

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
	
	public static DispositivoConcreto unDispositivoConcreto() {
		
		DispositivoInteligente base = unDispositivoInteligente();
		DispositivoConcreto dispositivo = new Heladera(base, false);
		return dispositivo;
		
	}
}
