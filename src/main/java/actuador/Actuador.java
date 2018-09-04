package actuador;

import dispositivosConcretos.*;


public abstract class Actuador {
	
    DispositivoConcreto dispositivo;

    public Actuador(DispositivoConcreto dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();

}