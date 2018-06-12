package mock;

import java.time.LocalDateTime;

import dispositivo.estados.Encendido;

public class EncendidoMock extends Encendido {

	public EncendidoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

	
}
