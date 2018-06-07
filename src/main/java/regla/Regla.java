package regla;

import java.util.ArrayList;
import java.util.List;

import actuador.Actuador;

public interface Regla {
	List<Actuador> actuadores = new ArrayList<Actuador>();

	Float TEMPERATURAMINIMA = 12.5F;
	Float INTENSIDADMAXIMA = 100F;
	Boolean MOVIMIENTO = true;
	
	// ↓ Estos son las condiciones ↓
	void temperatura(float unaTemperatura);
	void movimientoAfuera(boolean hayMovimiento);
	void luz(float intensidad);

	// Setters //
	void agregarActuador(Actuador actuador);
	void setTEMPERATURAMINIMA(Float TM);
	void setINTENSIDADMAXIMA(Float IM);
	void setMOVIMIENTO(Boolean mov);
}

/* ;;Ejemplo de como seria una Regla;;

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
