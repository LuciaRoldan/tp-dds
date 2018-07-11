package dispositivosConcretos;

import dispositivo.DispositivoBase;
import exceptionDispositivo.DispositivoBaseInvalidoException;

public class Lavarropas extends DispositivoConcreto{
	
	int capacidad;
	boolean esAutomatico;
	boolean tieneCalentamiento;
	
	public Lavarropas(DispositivoBase dispositivoBase, boolean esAutomatico, boolean tieneCalentamiento, int capacidad) {
		super(dispositivoBase);
		if (capacidad == 5) {
			if (esAutomatico) {
				if (!dispositivoBase.esInteligente() && tieneCalentamiento) {
					dispositivoBase.setPotencia(0.875);
				} else if (dispositivoBase.esInteligente() && !tieneCalentamiento){
					dispositivoBase.setPotencia(0.175);
					dispositivoBase.setBajoConsumo(true);
				} else {
					throw new DispositivoBaseInvalidoException();
				}
			}
			else if (!dispositivoBase.esInteligente()) {
				dispositivoBase.setPotencia(0.1275);
			} else {
				throw new DispositivoBaseInvalidoException();
			}
		}
		this.capacidad = capacidad;
		this.esAutomatico = esAutomatico;
		this.tieneCalentamiento = tieneCalentamiento;
	}
	
	//GETTERS Y SETTERS
	public boolean esAutomatico() {
		return esAutomatico;
	}
	public boolean tieneCalentamiento() {
		return tieneCalentamiento;
	}
	public int getCapacidad() {
		return capacidad;
	}
}
