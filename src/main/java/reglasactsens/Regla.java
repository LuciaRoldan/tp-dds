package reglasactsens;

import java.util.ArrayList;
import java.util.List;

public abstract class Regla {
	
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
	
	void ejecutarRegla() {
		if (this.verificarCumplimiento()) {
			actuadores.forEach(actuador -> actuador.actuar());
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
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
