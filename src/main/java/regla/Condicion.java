package regla;

import sensor.Sensor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Condicion {

	@ManyToMany
	List<Regla> reglas = new ArrayList<Regla>();
	boolean seCumple = false;
	//cada condicion va a tener una o mas variables de la magnitud que mide

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	public Integer numeroDeCondicion;
	
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
