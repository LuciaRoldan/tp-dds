package reglasactsens;

import dispositivos.Dispositivo;

public class VentanaActuador extends Actuador{
	//la accion es abrir y cerrar la ventana
	
	boolean abierta;
	
	VentanaActuador(Dispositivo dispositivo, boolean abierta) {
		super(dispositivo);
		this.abierta = abierta;
	}
	
	@Override
	public void actuar() { //true = abrir, false = cerrar
		if(abierta) {
			//ventana.abirir();
		}  else {
			//ventana.cerrar();
		}
	}

}
