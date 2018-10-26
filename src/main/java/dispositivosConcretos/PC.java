package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dispositivo.DispositivoBase;

@Entity
public class PC extends DispositivoConcreto {
	boolean deEscritorio;
	
	public PC(DispositivoBase dispositivoBase, boolean deEscritorio) {
		super(dispositivoBase);
		dispositivoBase.setPotencia(0.4);
		dispositivoBase.setBajoConsumo(true);
	}
	
	//GETTERS Y SETTERS
	public boolean esDeEscritorio() {
		return deEscritorio;
	}
}
