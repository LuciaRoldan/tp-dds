package reglasactsens;

import java.util.ArrayList;
import java.util.List;

public abstract class Condicion {
	
	List<Regla> reglas = new ArrayList<Regla>();
	boolean seCumple;
	
	public Condicion(List<Regla> reglas) {
		this.reglas = reglas;
		this.seCumple = false;
	} //METER la Condicion en la lista de interesados del Sensor que corresponda
	
	public abstract boolean evaluarCumplimiento(); //va a cambiar el estado de la variable seCumple
	
	public abstract void notificarMedicion(Integer medicion); //este método se implementa en cada Condicion concreta
	//y modifica la variable que corresponda de acuerdo al valor que le llegue
	
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
