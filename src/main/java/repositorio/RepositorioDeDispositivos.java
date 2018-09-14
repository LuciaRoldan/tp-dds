package repositorio;

import java.util.ArrayList;
import java.util.List;

import actuador.Actuador;
import dispositivosConcretos.DispositivoConcreto;
import regla.Condicion;
import regla.Regla;
import sensor.Sensor;
import transformador.Transformador;
import usuario.Usuario;

public class RepositorioDeDispositivos extends Repositorio {
	
	public void persistirDispositivo(DispositivoConcreto dispositivo) {
		this.persistir(dispositivo);
	}
	
	public DispositivoConcreto getDispositivo(Integer id) {
        return entityManager.find(DispositivoConcreto.class, id);
    }
	
	public DispositivoConcreto getDispositivoPorUsuario(int numeroCliente) {
		return (DispositivoConcreto) this.obtenerEntityManager().createQuery("SELECT d FROM DispositivoConcreto d WHERE d.numeroDeUsuario = :numeroCliente")
				.setParameter("numeroDeUsuario", numeroCliente).setMaxResults(1).getSingleResult();
	}
}
