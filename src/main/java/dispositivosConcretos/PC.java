package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class PC extends DispositivoConcreto {
	boolean deEscritorio;
	
	public PC(DispositivoBase dispositivoBase, boolean deEscritorio) {
		super(dispositivoBase);
		this.deEscritorio = true;
		if (!dispositivoBase.esInteligente() || !deEscritorio) {
			throw new DispositivoBaseInvalidoException();
		}
		dispositivoBase.setPotencia(0.4);
		dispositivoBase.setBajoConsumo(true);
	}
	
	//GETTERS Y SETTERS
	public boolean esDeEscritorio() {
		return deEscritorio;
	}
}
