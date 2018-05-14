package reglas;

import java.util.ArrayList;
import java.util.List;

import dispositivos.Dispositivo;

public abstract class Regla {
	List<Dispositivo> dispositivos = new ArrayList<>();
	
	// ↓ Estos serian "actuadores" ↓
	public void temperatura(float unaTemperatura) {};
	public void movimientoAfuera(boolean hayMovimiento) {};
	public void luz(float intensidad) {};
}

/* ;;Ejemplo de como seria una Regla;;

public class apagarLuz extends Regla{

	@Override
	public void luz(float intensidad){
		this.dispositivos.forEach(dispositivo -> dispositivo.apagar() );
	}
}
*/
