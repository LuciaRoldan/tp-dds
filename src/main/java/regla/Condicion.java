package regla;

import sensor.Sensor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


public abstract class Condicion {


	List<Regla> reglas = new ArrayList<Regla>();
	boolean seCumple = false;
	private Integer numeroDeCondicion;
	//cada condicion va a tener una o mas variables de la magnitud que mide

	public Condicion(){}
	
	public Condicion(Sensor sensor) {
		this.seCumple = false;
		sensor.agregarCondicion(this);
	}
	
	public abstract boolean evaluarCumplimiento(double medicion); //va a cambiar el estado de la variable seCumple
	
	public void notificarMedicion(double medicion) {
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
