package repositorio;

import java.util.ArrayList;
import java.util.List;

import actuador.Actuador;
import regla.Condicion;
import regla.Regla;
import sensor.Sensor;
import transformador.Transformador;

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
	
	public Regla getRegla(Integer id) {
        return entityManager.find(Regla.class,id);
    }
	
	@SuppressWarnings("unchecked")
	public List<Condicion> getListaCondiciones(){
		List<Condicion> lista = new ArrayList<Condicion>();
		lista = entityManager.createQuery("SELECT c FROM Condicion c").getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Actuador> getListaActuadores(){
		List<Actuador> lista = new ArrayList<Actuador>();
		lista = entityManager.createQuery("SELECT a FROM Actuador a").getResultList();
		return lista;
	}

}
