package estadoDispositivo;

import dispositivo.DispositivoInteligente;
import dispositivo.TipoDeDispositivo;

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
	public void encendete(TipoDeDispositivo dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}
	
	@Override
	public void activarAhorroDeEnergia(DispositivoInteligente dispositivo) {
	}
}
