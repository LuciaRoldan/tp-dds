package dispositivos;

import java.time.LocalDateTime;

public class ApagadoMock extends Apagado {
	
	public ApagadoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
