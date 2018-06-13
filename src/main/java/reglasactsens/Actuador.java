package reglasactsens;

import dispositivos.Dispositivo;

public abstract class Actuador {
	
    Dispositivo dispositivo;
    
    public Actuador(Dispositivo dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();
    
}