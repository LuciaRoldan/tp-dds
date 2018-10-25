package dispositivosConcretos;


import javax.persistence.Entity;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;
import exceptionDispositivo.DispositivoConcretoInvalidoException;

@Entity
public class AireAcondicionado extends DispositivoConcreto{

	int frigorias;
	
	public AireAcondicionado(DispositivoBase dispositivoBase, int frigorias) {
		super(dispositivoBase);
		if (!dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		if(frigorias == 2200) {
			dispositivoBase.setPotencia(1.013);
			dispositivoBase.setBajoConsumo(true);
		} else if (frigorias == 3500) {
			dispositivoBase.setPotencia(1.613);
		} else {
			throw new DispositivoConcretoInvalidoException();
		}
		this.frigorias = frigorias;
	}
	
	//GETTERS Y SETTERS
	public int getFrigorias() {
		return frigorias;
	}
}