package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Lampara extends DispositivoConcreto{

	boolean halogena;
	int w;
	
	public Lampara(DispositivoBase dispositivoBase, boolean halogena, int w) {
		super(dispositivoBase);
		if (!dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		if (halogena) {
			if (w == 40) {
				dispositivoBase.setPotencia(0.4);
			} else if (w == 60) {
				dispositivoBase.setPotencia(0.6);
			} else if (w == 100) {
				dispositivoBase.setPotencia(0.015);
			}
		} else {
			dispositivoBase.setBajoConsumo(true);
			if(w == 11) {
				dispositivoBase.setPotencia(0.011);
			} else if (w == 15) {
				dispositivoBase.setPotencia(0.015);
			} else if (w == 20) {
				dispositivoBase.setPotencia(0.2);
			}
		}
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
