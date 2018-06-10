package reglasactsens;

import dispositivos.Dispositivo;

public class VentanaActuador extends Actuador{
	//la accion es abrir y cerrar la ventana
	
	boolean abierta;
	
	VentanaActuador(Dispositivo dispositivo, boolean abierta) { //true es abrir
		super(dispositivo);
		this.abierta = abierta;
	}
	
	public void actuar() {
		
	}

}
