package repositorio;

import dispositivosConcretos.DispositivoConcreto;

public class RepositorioDeDispositivos extends Repositorio {
	
	public void persistirDispositivo(DispositivoConcreto dispositivo) {
		this.persistir(dispositivo);
	}
	
	public DispositivoConcreto getDispositivo(Integer id) {
        return entityManager.find(DispositivoConcreto.class, id);
    }
	
	public DispositivoConcreto getDispositivoPorUsuario(int numeroCliente) {
		return (DispositivoConcreto) this.obtenerEntityManager().createQuery("SELECT d FROM DispositivoConcreto d WHERE Cliente = :numeroCliente")
				.setParameter("numeroCliente", numeroCliente).setMaxResults(1).getSingleResult();
	}
}
