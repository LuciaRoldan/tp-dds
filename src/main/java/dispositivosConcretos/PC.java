package dispositivosConcretos;

import javax.persistence.Entity;

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
