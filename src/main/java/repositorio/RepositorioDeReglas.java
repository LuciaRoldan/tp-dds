package repositorio;

import actuador.Actuador;
import regla.Condicion;
import regla.Regla;
import sensor.Sensor;

public class RepositorioDeReglas extends Repositorio {
	
	public void persistirRegla(Regla regla) {
        this.persistir(regla);
    }
	
	public void persistirCondicion(Condicion condicion) {
        this.persistir(condicion);
    }
	
	public void persistirSensor(Sensor sensor) {
        this.persistir(sensor);
    }
	
	public void persistirActuador(Actuador actuador) {
        this.persistir(actuador);
    }
	
	
	

}
