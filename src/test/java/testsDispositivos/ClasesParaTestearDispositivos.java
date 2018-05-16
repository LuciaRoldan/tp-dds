package testsDispositivos;

import dispositivos.Dispositivo;
import dispositivos.DispositivoBuilder;
import dispositivos.DispositivoEstandar;
import dispositivos.DispositivoInteligente;

public class ClasesParaTestearDispositivos {
	public static Dispositivo unDispositivoInteligente() {
		DispositivoBuilder dispositivoBuilder = new DispositivoBuilder(
									"Aire Acondicionado",
									Long.valueOf(1000),
									false,
									new DispositivoInteligente(),
									0);
		Dispositivo dispositivo = dispositivoBuilder.construir();
		return dispositivo;
	}
	public static Dispositivo unDispositivoEstandar() {
		DispositivoBuilder dispositivoBuilder = new DispositivoBuilder(
									"Microondas",
									Long.valueOf(20000),
									false,
									new DispositivoEstandar(1),
									1);
		Dispositivo dispositivo = dispositivoBuilder.construir();
		return dispositivo;
	}
}
