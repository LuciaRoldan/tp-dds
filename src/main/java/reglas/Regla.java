package reglas;

import actuadores.Actuador;

import java.util.ArrayList;
import java.util.List;

public class Regla {
	
	List<Actuador> actuadores = new ArrayList<Actuador>();
	List<Condicion> condiciones = new ArrayList<Condicion>();
	
	
	public Regla(List<Actuador> actuadores, List<Condicion> condiciones) {
		this.actuadores = actuadores;
		this.condiciones = condiciones;
		condiciones.forEach(condicion -> condicion.agregarRegla(this));
	}

	boolean verificarCumplimiento() {
		return condiciones.stream().allMatch(condicion -> condicion.seCumple());
	}
	
	public void ejecutarRegla() {
		if (this.verificarCumplimiento()) {
			this.ejecutar();
		}
	}
	
	void ejecutar() {
		actuadores.forEach(actuador -> actuador.actuar());
	}

	public void agregarCondicion(Condicion condicion) {
		condiciones.add(condicion);
	}
	
	public void agregarActuador(Actuador actuador) {
		actuadores.add(actuador);
	}

	public List<Actuador> getActuadores() {
		return actuadores;
	}

	public List<Condicion> getCondiciones() {
		return condiciones;
	}
	
}
