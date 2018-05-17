package dispositivos;

import java.time.LocalDateTime;

public class AhorroDeEnergia extends Encendido {
	
	public AhorroDeEnergia(){}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}
	
	@Override
	public void activarAhorroDeEnergia(DispositivoInteligente dispositivo) {
	}
}
