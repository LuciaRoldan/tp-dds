package testsDispositivos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.DispositivoBuilder;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.Apagado;
import mock.EncendidoMock;

public class ClasesParaTestearDispositivos {

	public static DispositivoInteligenteInterfaz unDispositivoInteligente() {
		
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime ayer = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
		

		DispositivoInteligenteInterfaz dispositivo = new DispositivoInteligente("Aire Acondicionado",new Apagado(),10L);
		dispositivo.agregarEstado(new EncendidoMock(ayer, hoy));
		
		return dispositivo;

	}
	public static DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar(2000L, "Microondas", 1L));
	}
}
