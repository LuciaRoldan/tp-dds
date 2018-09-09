package repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import usuario.Usuario;

public class RepositorioDeUsuarios extends Repositorio {

	EntityManager entityManager = this.obtenerEntityManager();

	public static RepositorioDeUsuarios getInstancia() {
		
		RepositorioDeUsuarios instancia = new RepositorioDeUsuarios();
		
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
	}
	
	public Usuario recuperarUsuarioPorNombre(String nombreDeUsuario) {
		
		List<Usuario> usuarios = this.obtenerEntityManager()
				.createQuery("from Terminal where nombre = :nombreDeUsuario", Usuario.class)
				.setParameter("nombreDeUsuario", nombreDeUsuario).getResultList();
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		return null;
	}
	
	public void modificarGeolocalizacion(Usuario usuario, float coordenadaX, float coordenadaY) {
		
		if(this.recuperarUsuarioPorNombre(usuario.getNombreUsuario()) != null) {
			usuario.setCoordenadaX(coordenadaX);
			usuario.setCoordenadaY(coordenadaY);
			
			entityManager.merge(usuario);
		}
	}
}
