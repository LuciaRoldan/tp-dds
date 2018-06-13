package sensores;

import reglas.Condicion;

import java.util.ArrayList;
import java.util.List;


public class Sensor {
	
	//interesados
	List<Condicion> condiciones = new ArrayList<Condicion>();
	Integer medicion;
	
	public void agregarCondicion(Condicion unaCondicion){
	      condiciones.add(unaCondicion);
	}
	
	public void cambiarMedicion(Integer medicion) {
		this.medicion = medicion;
		this.notificarMedicion();
	}
	
	public void notificarMedicion() {
		condiciones.forEach(condicion -> condicion.evaluarCumplimiento(medicion));
	}	
}

