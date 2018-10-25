package repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import sensor.Sensor;
import usuario.Usuario;

public class RepositorioDeUsuarios extends Repositorio {

	EntityManager entityManager = this.obtenerEntityManager();

	public static RepositorioDeUsuarios getInstancia() {
		
		RepositorioDeUsuarios instancia = new RepositorioDeUsuarios();
		
		return instancia;
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.persistir(usuario);
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
	
	public Usuario recuperarUsuarioPorId(Integer id) {
		
		List<Usuario> usuarios = this.obtenerEntityManager()
				.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.numeroDeUsuario = :id", Usuario.class)
				.setParameter("id", id).getResultList();
		if (!usuarios.isEmpty()) {
			return usuarios.get(0);
		}
		return null;
	}
	
	public boolean isLoginValido(String user, String pass) {
		
		Usuario usuario = this.recuperarUsuarioPorNombreDeUsuario(user);
		System.out.println(usuario.getNombreUsuario());
		return usuario.getContrasena().matches(pass);
		
	}
	
	public List<Sensor> obtenerSensoresDeUsuario(Integer id){
		List<Sensor> sensores = this.obtenerEntityManager()
				.createQuery("SELECT sensor FROM Sensor sensor WHERE Cliente = :id", Sensor.class)
				.setParameter("id", id).getResultList();
		
		return sensores;
	}
}
