package mock;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import dispositivo.estados.Encendido;

import javax.persistence.Entity;

@Entity
public class EncendidoMock extends Encendido {

	public EncendidoMock(LocalDateTime inicio, LocalDateTime fin) {
		this.setInicio(inicio);
		this.setFin(fin);
	}
	
	
}
