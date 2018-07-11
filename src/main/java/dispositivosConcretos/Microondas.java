package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Microondas extends DispositivoConcreto{
	boolean convencional;
	
	public Microondas(DispositivoBase dispositivoBase, boolean convencional) {
		super(dispositivoBase);
		if (dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		dispositivoBase.setBajoConsumo(true);
		dispositivoBase.setPotencia(0.64);
		this.convencional = convencional;
	}
	
	//GETTERS Y SETTERS
	public boolean esConvencional() {
		return convencional;
	}
}
