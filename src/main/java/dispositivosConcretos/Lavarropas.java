package dispositivosConcretos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dispositivo.DispositivoBase;

@Entity
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
