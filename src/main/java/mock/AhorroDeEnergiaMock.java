package mock;

import estadoDispositivo.AhorroDeEnergia;

import java.time.LocalDateTime;

public class AhorroDeEnergiaMock extends AhorroDeEnergia {
	
	public AhorroDeEnergiaMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
