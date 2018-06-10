package mock;

import java.time.LocalDateTime;

import dispositivo.estados.Apagado;

public class ApagadoMock extends Apagado {
	
	public ApagadoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
