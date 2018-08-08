package dispositivosConcretos;
import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Heladera extends DispositivoConcreto {
	
	boolean tieneFreezer;
	
	public Heladera(DispositivoBase dispositivoBase, boolean tieneFreezer) {
		super(dispositivoBase);
		this.tieneFreezer = tieneFreezer;
	}
	
	//GETTERS Y SETTERS
	public boolean tieneFreezer() {
		return tieneFreezer;
	}
}
