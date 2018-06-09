package testsDispositivos;

import dispositivo.DispositivoBuilder;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligenteConcreto;

public class ClasesParaTestearDispositivos {
	public static Dispositivo unDispositivoInteligente() {
		DispositivoBuilder dispositivoBuilder = new DispositivoBuilder(
									"Aire Acondicionado",
									Long.valueOf(1000),
									new DispositivoInteligenteConcreto(),
									0);
		Dispositivo dispositivo = dispositivoBuilder.construir();
		return dispositivo;
	}
	public static Dispositivo unDispositivoEstandar() {
		DispositivoBuilder dispositivoBuilder = new DispositivoBuilder(
									"Microondas",
									Long.valueOf(20000),
									new DispositivoEstandar(),
									1);
		Dispositivo dispositivo = dispositivoBuilder.construir();
		return dispositivo;
	}
}
