package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Plancha extends DispositivoConcreto{
	
	boolean aVapor;
	
	public Plancha(DispositivoBase dispositivoBase, boolean aVapor) {
		super(dispositivoBase);
		if (dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		dispositivoBase.setBajoConsumo(true);
		dispositivoBase.setPotencia(0.75);
		this.aVapor = aVapor;
	}
	
	//GETTERS Y SETTERS
	public boolean esAVapor() {
		return aVapor;
	}

}
