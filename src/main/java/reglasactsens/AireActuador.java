package reglasactsens;

import dispositivos.Dispositivo;

public class AireActuador extends Actuador{
	
	int temperatura;
	//la accion es cambiar la temperatura del aire
	
	public AireActuador(Dispositivo dispositivo, int temperatura) {
		super(dispositivo);
		this.temperatura = temperatura;
	}

	@Override
	public void actuar() {
		
	}
	
	public void apagar() {
//		this.dispositivo.apagate();
	}
	
	public void prender() {
//		this.dispositivo.prendete();
	}
	
	public void bajarTemperatura() {
		
	}

}

