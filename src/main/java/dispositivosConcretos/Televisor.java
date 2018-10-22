package dispositivosConcretos;

import javax.persistence.Entity;

import dispositivo.DispositivoBase;


public class Televisor extends DispositivoConcreto{
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
