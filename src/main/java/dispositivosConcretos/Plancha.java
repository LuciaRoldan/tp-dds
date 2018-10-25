package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dispositivo.DispositivoBase;

@Entity
public class Plancha extends DispositivoConcreto{
	boolean aVapor;
	
	public Plancha(DispositivoBase dispositivoBase, boolean aVapor) {
		super(dispositivoBase);
		dispositivoBase.setBajoConsumo(true);
		dispositivoBase.setPotencia(0.75);
		this.aVapor = aVapor;
	}
	
	//GETTERS Y SETTERS
	public boolean esAVapor() {
		return aVapor;
	}

}
