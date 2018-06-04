package reglasactsens;

import java.util.ArrayList;
import java.util.List;


public abstract class Sensor {

	List<Condicion> condiciones = new ArrayList<Condicion>();
	
	public void agregarCondicion(Condicion unaCondicion){
	      condiciones.add(unaCondicion);
	}

	public void notificarMedicion() {
		Integer medicion = this.recibirMedicion();
		condiciones.forEach(condicion -> condicion.notificarMedicion(medicion));
	}
	
	public abstract Integer recibirMedicion(); //cuando le llega la medicion de no se donde. Implementa cada
	//sensor concreto.
	
}
