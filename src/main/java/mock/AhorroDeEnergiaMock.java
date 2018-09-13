package mock;

import java.time.LocalDateTime;

import dispositivo.estados.AhorroDeEnergia;

import javax.persistence.Entity;

@Entity
public class AhorroDeEnergiaMock extends AhorroDeEnergia {
	
	public AhorroDeEnergiaMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
