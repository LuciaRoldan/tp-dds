package testsDispositivo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;
import dispositivo.estados.Apagado;
import mock.EncendidoMock;

public class ClasesParaTestearDispositivos {

	public static DispositivoInteligente unDispositivoInteligente() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
		

		DispositivoInteligente dispositivo = new DispositivoInteligenteConcreto("Aire Acondicionado",new Apagado(),10L);
		dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		return dispositivo;

	}
	public static DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar(2000L, "Microondas", 1L));
	}
}
