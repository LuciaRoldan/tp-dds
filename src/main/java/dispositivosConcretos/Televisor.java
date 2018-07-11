package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Televisor extends DispositivoConcreto{
	TipoPantalla pantalla;
	int pulgadas;
	
	public Televisor(DispositivoBase dispositivoBase, TipoPantalla pantalla, int pulgadas) {
		super(dispositivoBase);		
		//Perdon
		if(pantalla != TipoPantalla.LED && dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		if(pantalla == TipoPantalla.LED && !dispositivoBase.esInteligente()) {
			throw new DispositivoBaseInvalidoException();
		}
		if (pantalla == TipoPantalla.TF) {
			if (pulgadas == 21) {
				dispositivoBase.setPotencia(0.075);
			} else if (29 < pulgadas && pulgadas < 34) {
				dispositivoBase.setPotencia(0.175);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		}
		if (pantalla == TipoPantalla.LCD) {
			if (pulgadas == 40) {
				dispositivoBase.setPotencia(0.18);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		}
		if (pantalla == TipoPantalla.LED) {
			dispositivoBase.setBajoConsumo(true);
			if (pulgadas == 24) {
				dispositivoBase.setPotencia(0.04);
			} else if (pulgadas == 32) {
				dispositivoBase.setPotencia(0.055);
			} else if (pulgadas == 40) {
				dispositivoBase.setPotencia(0.08);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		}
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
