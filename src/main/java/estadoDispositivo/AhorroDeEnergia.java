package estadoDispositivo;

import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;

import java.time.LocalDateTime;

public class AhorroDeEnergia extends Encendido {
	
	private LocalDateTime inicio;
	private LocalDateTime fin;
	
	public AhorroDeEnergia() {
		inicio = LocalDateTime.now();
	}
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}
	

	public void activarAhorroDeEnergia(DispositivoInteligente dispositivo) {
	}
}
