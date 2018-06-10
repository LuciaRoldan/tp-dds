package mock;

import java.time.LocalDateTime;

import dispositivo.estados.AhorroDeEnergia;

public class AhorroDeEnergiaMock extends AhorroDeEnergia {
	
	public AhorroDeEnergiaMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
