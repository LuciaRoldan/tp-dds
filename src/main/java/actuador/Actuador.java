package actuador;

import dispositivo.DispositivoInteligenteInterfaz;


public abstract class Actuador {
	
    DispositivoInteligenteInterfaz dispositivo;

    public Actuador(DispositivoInteligenteInterfaz dispositivo) {
    	this.dispositivo = dispositivo;
    }

    public abstract void actuar();
    
}