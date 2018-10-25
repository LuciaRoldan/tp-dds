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
//		String nombre = request.body().substring(5); Aca Ro usa el parser magico que habias hecho
//		System.out.println(nombre);
		
//		Aca deberia funcionar con lo que haya cargado en la base de datos
		
//		usuario = repoDeUsuarios.recuperarUsuarioPorNombreDeUsuario(nombre);
//		if(usuario.tipoDeUsuario == TipoDeUsuario.CLIENTE) {
//			response.redirect("/usuario");
//			vista = new ModelAndView(null, "cliente.hbs");
//		} else if (usuario.tipoDeUsuario == TipoDeUsuario.ADMINISTRADOR) {
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
}
		
		