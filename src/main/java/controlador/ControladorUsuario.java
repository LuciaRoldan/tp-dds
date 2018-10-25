package controlador;

import com.github.jknack.handlebars.Handlebars;

import repositorio.RepositorioDeUsuarios;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;
import usuario.TipoDeUsuario;
import usuario.Usuario;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ControladorUsuario implements WithGlobalEntityManager, TransactionalOps{
	
	private static ControladorUsuario instancia = null;
	String error="Error combinacion de usuario y contraseña invalidos";
	public Usuario usuario = null;
	
	public RepositorioDeUsuarios repoDeUsuarios = RepositorioDeUsuarios.getInstancia();

	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuario();
		}
		return instancia;
	}
	
	public ModelAndView buscarUsuario(Request request, Response response) throws IOException {

		System.out.println(request.body());
		String p = Arrays.asList(request.body().split("&")).get(0);
		String user = Arrays.asList(p.split("=")).get(1);

		String p2 = Arrays.asList(request.body().split("&")).get(1);
		String pass = Arrays.asList(p2.split("=")).get(1);

		System.out.println(user);
		System.out.println(pass);
		
//		Aca deberia funcionar con lo que haya cargado en la base de datos
		
//		usuario = repoDeUsuarios.recuperarUsuarioPorNombreDeUsuario(user);
//		if(usuario.tipoDeUsuario == TipoDeUsuario.CLIENTE && contraseniaValida(usuario, pass)) {
//			response.redirect("/usuario");
//			vista = new ModelAndView(null, "cliente.hbs");
//		} else if (usuario.tipoDeUsuario == TipoDeUsuario.ADMINISTRADOR && contraseniaValida(usuario, pass)) {
//			response.redirect("/admin");
//			vista = new ModelAndView(null, "admin.hbs");
//		} else {
//			response.status(400);
//			Map<String, Object> viewModel = new HashMap<>();
//			viewModel.put("error",error);
//			vista =  new ModelAndView(viewModel , "login.hbs");
//		}
//		HARDCODE HASTA QUE FUNCIONE PERSISTENCIA
		
		ModelAndView vista = null;
		
		if(request.body().equals("user=1234&password=1234")) {
			response.redirect("/usuario");
			vista = new ModelAndView(null, "cliente.hbs");
		}else if(request.body().equals("user=4321&password=4321")){
			response.redirect("/admin");
			vista = new ModelAndView(null, "admin.hbs");
		}else {
			response.status(400);
			Map<String, Object> viewModel = new HashMap<>();
		}
		return vista;
	}

	private boolean contraseniaValida(Usuario usuario, String contrasenia) {
		return usuario.contrasena == contrasenia;
	}

}
		
		