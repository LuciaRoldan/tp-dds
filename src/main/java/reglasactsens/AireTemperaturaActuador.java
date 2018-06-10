package reglasactsens;

import dispositivos.Dispositivo;

public class AireTemperaturaActuador extends Actuador{
	
	int temperatura; //la accion es cambiar la temperatura del aire
	
	public AireTemperaturaActuador(Dispositivo dispositivo, int temperatura) {
		super(dispositivo);
		this.temperatura = temperatura;
	}

	@Override
	public void actuar() {
		//this.dispositivo.setTemperatura(temperatura);
	}
}

