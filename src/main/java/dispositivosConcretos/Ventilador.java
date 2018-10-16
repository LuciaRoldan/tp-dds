package dispositivosConcretos;

import javax.persistence.Entity;
import dispositivo.DispositivoBase;

@Entity
public class Ventilador extends DispositivoConcreto {
	
	boolean deTecho;

	public Ventilador(DispositivoBase dispositivoBase, boolean deTecho) {
		super(dispositivoBase);
		this.deTecho = deTecho;
	}
	
	//GETTERS Y SETTERS
	public boolean esDeTecho() {
		return deTecho;
	}
}
