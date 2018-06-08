package dispositivos;

import java.time.LocalDateTime;

public class EncendidoMock extends Encendido{

	public EncendidoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

	
}
