package sensor;

import regla.Condicion;

import java.util.ArrayList;
import java.util.List;


public class Sensor {
	
	//interesados
	List<Condicion> condiciones = new ArrayList<Condicion>();
	double medicion;
	
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
}

