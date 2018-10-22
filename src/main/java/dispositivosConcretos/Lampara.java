package dispositivosConcretos;

import javax.persistence.Entity;

import dispositivo.DispositivoBase;


public class Lampara extends DispositivoConcreto{

	boolean halogena;
	int w;
	
	public Lampara(DispositivoBase dispositivoBase, boolean halogena, int w) {
		super(dispositivoBase);
		this.w = w;
		this.halogena = halogena;
	}
	
	//GETTERS Y SETTERS
	public boolean esHalogena() {
		return halogena;
	}
	public int getW() {
		return w;
	}
}
