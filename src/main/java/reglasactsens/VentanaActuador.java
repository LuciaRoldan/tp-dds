package reglasactsens;

import dispositivos.Dispositivo;

public class VentanaActuador extends Actuador{
	//la accion es abrir y cerrar la ventana
	
	boolean abrir;
	
	VentanaActuador(Dispositivo dispositivo, boolean abrir) { //true es abrir
		super(dispositivo);
		this.abrir = abrir;
	}
	
	@Override
	public void actuar() {

	}

}
