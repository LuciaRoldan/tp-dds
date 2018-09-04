package dispositivosConcretos;

import dispositivo.DispositivoBase;

public class AireAcondicionado extends DispositivoConcreto{

	int frigorias;
	
	public AireAcondicionado(DispositivoBase dispositivoBase, int frigorias) {
		super(dispositivoBase);
		this.frigorias = frigorias;
	}
	
	//GETTERS Y SETTERS
	public int getFrigorias() {
		return frigorias;
	}
}
