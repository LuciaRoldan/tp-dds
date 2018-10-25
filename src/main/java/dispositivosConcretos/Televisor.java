package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import dispositivo.DispositivoBase;

@Entity
public class Televisor extends DispositivoConcreto{
	@Transient
	TipoPantalla pantalla;
	int pulgadas;
	
	public Televisor(DispositivoBase dispositivoBase, TipoPantalla pantalla, int pulgadas) {
		super(dispositivoBase);
		this.pantalla = pantalla;
		this.pulgadas = pulgadas;
	}

	//GETTERS Y SETTERS
	public TipoPantalla getPantalla() {
		return pantalla;
	}
	
	public int getPulgadas() {
		return pulgadas;
	}
}
