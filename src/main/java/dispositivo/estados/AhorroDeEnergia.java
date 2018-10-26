package dispositivo.estados;

import dispositivo.DispositivoInteligenteAbstracto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class AhorroDeEnergia extends Encendido {
	
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
	public void encendete(DispositivoInteligenteAbstracto dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}
	

	public void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivo) {
	}
}
