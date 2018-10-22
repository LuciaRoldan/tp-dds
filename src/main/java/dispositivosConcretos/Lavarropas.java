package dispositivosConcretos;

import javax.persistence.Entity;

import dispositivo.DispositivoBase;


public class Lavarropas extends DispositivoConcreto{
	
	int capacidad;
	boolean esAutomatico;
	boolean tieneCalentamiento;
	
	public Lavarropas(DispositivoBase dispositivoBase, boolean esAutomatico, boolean tieneCalentamiento, int capacidad) {
		super(dispositivoBase);
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
