package regla;

import sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class Condicion {
	
	List<Regla> reglas = new ArrayList<Regla>();
	boolean seCumple;
	//cada condicion va a tener una o mas variables de la magnitud que mide
	
	public Condicion(Sensor sensor) {
		this.seCumple = false;
		sensor.agregarCondicion(this);
	}
	
	public abstract boolean evaluarCumplimiento(Integer medicion); //va a cambiar el estado de la variable seCumple
	
	public void notificarMedicion(Integer medicion) {
		boolean nuevoCumplimiento = this.evaluarCumplimiento(medicion);
		if (nuevoCumplimiento != this.seCumple) {
			seCumple = nuevoCumplimiento;
			this.notificarCambioCumplimiento();
		}
	}
	
	public void notificarCambioCumplimiento() {
		reglas.forEach(regla -> regla.ejecutarRegla());
	}
	

	//getters y setters
	
	public void agregarRegla(Regla regla) {
		reglas.add(regla);
	}
	
	public boolean seCumple() {
		return this.seCumple;
	}
}
