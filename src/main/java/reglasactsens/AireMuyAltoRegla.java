package reglasactsens;

import dispositivos.Dispositivo;
import dispositivos.DispositivoInteligente;

public class AireMuyAltoRegla extends Regla{

	Dispositivo aire = new Dispositivo();
	AireActuador actuador = new AireActuador(aire,28);
	
	public AireMuyAltoRegla() {
		this.agregarActuador(actuador);
	}

//	aca en realidad deberia especificar la funcion del actuador como por ejemplo si aca quiero bajar o apagar el aire, hacer eso
	@Override
	public void ejecutar() {
		this.getActuadores().forEach(actuador -> actuador.actuar());
	}	
}

