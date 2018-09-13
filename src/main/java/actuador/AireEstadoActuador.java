package actuador;

import dispositivosConcretos.DispositivoConcreto;

public class AireEstadoActuador extends Actuador {
	
	boolean encender; //la accion es cambiar la temperatura del aire
	
	public AireEstadoActuador(DispositivoConcreto dispositivo, boolean encender) {
		super(dispositivo);
		this.encender = encender;
	}
	
	public void setEncender(boolean encender) {
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