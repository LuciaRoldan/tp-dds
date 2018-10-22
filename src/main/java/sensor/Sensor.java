package sensor;

import regla.Condicion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


public class Sensor {
	
	//interesados

	@ManyToMany
	List<Condicion> condiciones = new ArrayList<Condicion>();
	double medicion;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer numeroDeSensor;
	
	public Sensor() {}
	
	public void agregarCondicion(Condicion unaCondicion){
	      condiciones.add(unaCondicion);
	}
	
	public void cambiarMedicion(double medicion) {
		this.medicion = medicion;
		this.notificarMedicion();
	}
	
	public void notificarMedicion() {
		condiciones.forEach(condicion -> condicion.notificarMedicion(medicion));
	}

    public Integer getNumeroDeSensor() {
		return this.numeroDeSensor;
    }
}

