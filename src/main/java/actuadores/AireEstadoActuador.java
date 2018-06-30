package actuadores;

import dispositivo.DispositivoInteligenteInterfaz;

public class AireEstadoActuador extends Actuador {
	
	boolean encender; //la accion es cambiar la temperatura del aire
	
	public AireEstadoActuador(DispositivoInteligenteInterfaz dispositivo, boolean encender) {
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