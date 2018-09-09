package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import java.time.LocalDateTime;

public class AhorroDeEnergia extends Encendido {
	
	public AhorroDeEnergia() {
		inicio = LocalDateTime.now();
	}

	public void encendete(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();
		dispositivo.setEstado(new Encendido());
	}
	
	public void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivo) {
	}
}
