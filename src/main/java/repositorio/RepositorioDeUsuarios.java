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
		this.persistir(usuario); //Ivi usa esta funcion que ya existe!
	}
	
	public Usuario recuperarUsuarioPorNombreDeUsuario(String nombreDeUsuario) {
		
		List<Usuario> usuarios = this.obtenerEntityManager()
				.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.nombreDeUsuario = :nombreDeUsuario", Usuario.class)
				.setParameter("nombreDeUsuario", nombreDeUsuario).getResultList();
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		return null;
	}
	
	//Ivi no se si es neceario que tengamos esta funcion
	public void modificarGeolocalizacion(Usuario usuario, float coordenadaX, float coordenadaY) {
		
		if(this.recuperarUsuarioPorNombreDeUsuario(usuario.getNombreUsuario()) != null) {
			usuario.setCoordenadaX(coordenadaX);
			usuario.setCoordenadaY(coordenadaY);
			
			entityManager.merge(usuario);
		}
	}
}
