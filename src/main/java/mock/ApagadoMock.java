package mock;

import java.time.LocalDateTime;

import dispositivo.estados.Apagado;

import javax.persistence.Entity;


public class ApagadoMock extends Apagado {
	
	public ApagadoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}

}
