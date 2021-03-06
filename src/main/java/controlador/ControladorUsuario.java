package controlador;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import repositorio.RepositorioDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.TipoDeUsuario;
import usuario.Usuario;

public class ControladorUsuario implements WithGlobalEntityManager, TransactionalOps{
	
	private static ControladorUsuario instancia = null;
	String error="Error combinacion de usuario y contrasenia invalidos";
	public Usuario usuario = null;

	public RepositorioDeUsuarios repoDeUsuarios = RepositorioDeUsuarios.getInstancia();

	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuario();
		}
		return instancia;
	}
	
	public ModelAndView buscarUsuario(Request request, Response response) throws IOException {

		ModelAndView vista = null;
		System.out.println(request.body());
		String p = Arrays.asList(request.body().split("&")).get(0);
		String user = Arrays.asList(p.split("=")).get(1);

		String p2 = Arrays.asList(request.body().split("&")).get(1);
		String pass = Arrays.asList(p2.split("=")).get(1);

		usuario = repoDeUsuarios.recuperarUsuarioPorNombreDeUsuario(user);
		System.out.print(usuario.getNombreUsuario());

		if ((usuario.getTipoDeUsuario() == TipoDeUsuario.CLIENTE) && contraseniaValida(usuario, pass)) {
			
			String ruta = "/usuario/" + usuario.getId().toString();
			ruta.concat(String.valueOf(usuario.getId()));
			response.redirect(ruta);
			
			vista = new ModelAndView(null, "cliente.hbs");
		} else if ((usuario.getTipoDeUsuario() == TipoDeUsuario.ADMINISTRADOR) && contraseniaValida(usuario, pass)) {
			response.redirect("/admin");
			vista = new ModelAndView(null, "admin.hbs");
		} else {
			response.status(400);
			Map<String, Object> viewModel = new HashMap<>();
			viewModel.put("error", error);
			vista = new ModelAndView(viewModel, "login.hbs");
		}

		return vista;
	}

	private boolean contraseniaValida(Usuario usuario, String contrasenia) {
		String contrasena = usuario.getContrasena();
		return contrasenia.equals(contrasena);
	}

}
		
		