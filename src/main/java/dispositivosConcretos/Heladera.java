package dispositivosConcretos;
import javax.persistence.Entity;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

@Entity
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
