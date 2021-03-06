package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dispositivo.DispositivoBase;

@Entity
public class Lampara extends DispositivoConcreto{

	boolean halogena;
	int w;
	
	public Lampara(DispositivoBase dispositivoBase, boolean halogena, int w) {
		super(dispositivoBase);
		this.w = w;
		this.halogena = halogena;
	}
	
	//GETTERS Y SETTERS
	public boolean esHalogena() {
		return halogena;
	}
	public int getW() {
		return w;
	}
}
