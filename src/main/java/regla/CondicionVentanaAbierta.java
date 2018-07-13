package regla;


import sensor.Sensor;

public class CondicionVentanaAbierta extends Condicion {
	boolean abierta; //dice si quiero que la ventana este abierta o cerrada. true = abierta, false = cerrada
	
	public CondicionVentanaAbierta(Sensor sensor, boolean abierta) {
		super(sensor);
		this.abierta = abierta;
	}

	@Override
	public boolean evaluarCumplimiento(Integer medicionPorcentajeAbierta) { //porcentaje de abierta de la ventana lol
		if(abierta) { //Si esta mas del 1% se considera abierta
			return medicionPorcentajeAbierta > 1;
		}else {
			return medicionPorcentajeAbierta < 1;
		}
	}
	
}
