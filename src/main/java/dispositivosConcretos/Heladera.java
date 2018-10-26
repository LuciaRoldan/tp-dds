package dispositivosConcretos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
