package regla;

import sensor.Sensor;

public class CondicionTemperaturaAlta extends Condicion {
	int temperaturaLimite;
	
	public CondicionTemperaturaAlta(Sensor sensor, int temperaturaLimite) {
		super(sensor);
		this.temperaturaLimite = temperaturaLimite;
	}

	@Override
	public boolean evaluarCumplimiento(double medicion) {
		return medicion > this.temperaturaLimite;
	}
}
