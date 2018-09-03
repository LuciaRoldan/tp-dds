package regla;

import sensor.Sensor;

public class CondicionConsumoSuperior extends Condicion {
	double consumoLimite;
	
	public CondicionConsumoSuperior(Sensor sensor, double consumoLimite) {
		super(sensor);
		this.consumoLimite = consumoLimite;
	}

	@Override
	public boolean evaluarCumplimiento(double medicion) {
		return medicion > this.consumoLimite;
	}
}
