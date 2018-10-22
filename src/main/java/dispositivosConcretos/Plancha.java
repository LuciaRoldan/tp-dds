package dispositivosConcretos;

import javax.persistence.Entity;

import dispositivo.DispositivoBase;


public class Plancha extends DispositivoConcreto{
	
	boolean aVapor;
	
	public Plancha(DispositivoBase dispositivoBase, boolean aVapor) {
		super(dispositivoBase);
		dispositivoBase.setBajoConsumo(true);
		dispositivoBase.setPotencia(0.75);
		this.aVapor = aVapor;
	}
	
	//GETTERS Y SETTERS
	public boolean esAVapor() {
		return aVapor;
	}

}
