package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dispositivo.DispositivoBase;

@Entity
public class Microondas extends DispositivoConcreto{
	boolean convencional;
	
	public Microondas(DispositivoBase dispositivoBase, boolean convencional) {
		super(dispositivoBase);
		dispositivoBase.setBajoConsumo(true);
		dispositivoBase.setPotencia(0.64);
		this.convencional = convencional;
	}
	
	//GETTERS Y SETTERS
	public boolean esConvencional() {
		return convencional;
	}
}
