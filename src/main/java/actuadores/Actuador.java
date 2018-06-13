package actuadores;

import dispositivo.DispositivoInteligente;


public abstract class Actuador {
	
    DispositivoInteligente dispositivo;

    public Actuador(DispositivoInteligente dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();
    
}