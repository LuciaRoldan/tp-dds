package dispositivosConcretos;
import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Heladera extends DispositivoConcreto {
	
	boolean tieneFreezer;
	
	public Heladera(DispositivoBase dispositivoBase, boolean tieneFreezer) {
		super(dispositivoBase);
		if (!dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		dispositivoBase.setBajoConsumo(true);
		if(tieneFreezer) {
			dispositivoBase.setPotencia(0.09);
		} else {
			dispositivoBase.setPotencia(0.075);
		}
		this.tieneFreezer = tieneFreezer;
	}
	
	//GETTERS Y SETTERS
	public boolean tieneFreezer() {
		return tieneFreezer;
	}
}
