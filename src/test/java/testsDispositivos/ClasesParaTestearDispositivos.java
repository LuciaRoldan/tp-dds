package testsDispositivos;

import dispositivo.DispositivoBuilder;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;
import dispositivo.estados.Apagado;

public class ClasesParaTestearDispositivos {

	public static DispositivoInteligente unDispositivoInteligente() {

		return (new DispositivoInteligenteConcreto("Aire Acondicionado",new Apagado(),10L));

	}
	public static DispositivoEstandar unDispositivoEstandar() {

		return (new DispositivoEstandar(2000L, "Microondas", 1L));
	}
}
