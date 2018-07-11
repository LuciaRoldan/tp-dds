package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Ventilador extends DispositivoConcreto {
	
	boolean deTecho;

	public Ventilador(DispositivoBase dispositivoBase, boolean deTecho) {
		super(dispositivoBase);
		dispositivoBase.setBajoConsumo(true);
		if (deTecho) {
			if (!dispositivoBase.esInteligente()) {
				throw new DispositivoBaseInvalidoException();
			}
			dispositivoBase.setPotencia(0.06);
		} else if (dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		} else {
			dispositivoBase.setPotencia(0.09);
		}
		this.deTecho = deTecho;
	}
	
	//GETTERS Y SETTERS
	public boolean esDeTecho() {
		return deTecho;
	}
}
