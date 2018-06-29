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
			dispositivoBase.setkWh((long) 0.09);
		} else {
			dispositivoBase.setkWh((long) 0.075);
		}
	}
	
	//GETTERS Y SETTERS
	public boolean tieneFreezer() {
		return tieneFreezer;
	}
}
