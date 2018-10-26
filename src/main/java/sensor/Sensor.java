package sensor;

import regla.Condicion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sensor {
	
	//interesados

	@ManyToMany //Deberia ser un one to many?
	List<Condicion> condiciones = new ArrayList<Condicion>();
	double medicion;
	String descripcion;
	String unidad;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer numeroDeSensor;
	
	public Sensor() {}
	
	public Integer getId() {
		return this.numeroDeSensor;
	}
	
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
    
    public void agregarDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
    
    public void agregarUnidad(String unidad) {
    	this.unidad = unidad;
    }

	public double getMedicion() {
		return medicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUnidad() {
		return unidad;
	}
    
    
}

