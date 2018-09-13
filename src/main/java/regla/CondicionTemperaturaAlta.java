package regla;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import sensor.Sensor;

@Entity
public class CondicionTemperaturaAlta extends Condicion {
	int temperaturaLimite;
	
	public CondicionTemperaturaAlta(Sensor sensor, int temperaturaLimite) {
		super(sensor);
		this.temperaturaLimite = temperaturaLimite;
	}
	
	public void setTemperatura(int temperatura) {
		this.temperaturaLimite = temperatura;
	}

	@Override
	public boolean evaluarCumplimiento(double medicion) {
		return medicion > this.temperaturaLimite;
	}
}
