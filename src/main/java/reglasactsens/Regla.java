package reglasactsens;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
	
	List<Actuador> actuadores = new ArrayList<Actuador>();
	List<Condicion> condiciones = new ArrayList<Condicion>();
	
//	public Regla(List<Actuador> actuadores) {
//		this.actuadores = actuadores;
//	}

	boolean verificarCumplimiento() {
		return condiciones.stream().allMatch(condicion -> condicion.seCumple());
	}
	
	void ejecutarRegla() {
		if (this.verificarCumplimiento()) {
			this.ejecutar();
		}
	}
	
	void ejecutar() {}

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
//Dudas:
//		las reglas y las condiciones se va a hacer un bucle llamando en los constructores a la otra
//		se complica el polimorfismo de los actuadores con la funcion actuar si quiero hacer algo especifico
//		cuando hago la regla directamente ahi en el ejecutar deberia poder decirle al actuador que quiero que haga dependiendo de lo que busca la regla
//		que paso con todas los metodos de apagate y prendete de los dispositivos
	
	
	
	
	
	
	
	
	
	
	
/*
	public static Float TEMPERATURAMINIMA = 12.5F;
	public static Float INTENSIDADMAXIMA = 100F;
	public static Boolean MOVIMIENTO = true;
	
	// ↓ Estos son las condiciones ↓
	public void temperatura(float unaTemperatura) {};
	public void movimientoAfuera(boolean hayMovimiento) {};
	public void luz(float intensidad) {};

	// Setters //
	public void agregarActuador(Actuador actuador){this.actuadores.add(actuador);}
	public void setTEMPERATURAMINIMA(Float TM){this.TEMPERATURAMINIMA = TM;}
	public void setINTENSIDADMAXIMA(Float IM){this.INTENSIDADMAXIMA = IM;}
	public void setMOVIMIENTO(Boolean mov){this.MOVIMIENTO = mov;}
}

;;Ejemplo de como seria una Regla;;

public class apagarLuz extends Regla{

	@Override
	public void temperatura(Float unaTemperatura){
		if (unaTemperatura < TEMPERATURAMINIMA)
		this.actuadors.forEach(actuador -> actuador.haceFrio() );
	}

	@Override
	public void movimientoAfuera(Boolean hayMovimiento){
		if (hayMovimiento == MOVIMIENTO)
		this.actuadores.forEach(actuador -> actuador.movimiento() );
	}

	@Override
	public void movimientoAfuera(Boolean hayMovimiento){
		if (hayMovimiento == MOVIMIENTO)
		this.actuadores.forEach(actuador -> actuador.movimiento() );
	}



}
*/
