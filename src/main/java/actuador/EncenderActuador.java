package actuador;

import dispositivosConcretos.DispositivoConcreto;

public class EncenderActuador extends Actuador {
	boolean encender;
	
	public EncenderActuador(DispositivoConcreto dispositivo, boolean encender) {
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
