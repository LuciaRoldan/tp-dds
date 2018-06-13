package reglasactsens;

import dispositivos.Dispositivo;

public class AireEstadoActuador extends Actuador{
	
	boolean encender; //la accion es cambiar la temperatura del aire
	
	public AireEstadoActuador(Dispositivo dispositivo, boolean encender) {
		super(dispositivo);
		this.encender = encender;
	}

	@Override
	public void actuar() {
		if (encender) {
			this.dispositivo.encendete();
		} else {
			this.dispositivo.apagate();
		}
	}
}