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
import usuario.Cliente;
import usuario.Usuario;

public class ControladorAdministrador extends ControladorUsuario{

	public RepositorioDeUsuarios repoDeUsuarios = RepositorioDeUsuarios.getInstancia();
	Usuario cliente;
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		return new ModelAndView(null , "admin.hbs");
	}
	
	public String parsearId(String body) {
		String id = null;
		if(body.split("=").length>1) {
			id = Arrays.asList(body.split("=")).get(1);
		}
		return id;
	}

	public ModelAndView infoUsuario(Request request, Response response) {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = request.queryParams("NUMERODECLIENTE");
		
		if(id.isEmpty()) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "admin.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			//chequear que pasa cuando no encuentra el usuario ..
			viewModel.put("cliente", cliente);

			vista = new ModelAndView(viewModel, "admin.hbs");
			return vista; //esta vista es la misma que antes pero con la tablita completa con consumos
		}
		
		//String id = parsearId(request.body());
		
		System.out.printf("El id ingresado es: " + id);
		
		cliente = repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

		//chequear que pasa cuando no encuentra el usuario ..
		viewModel.put("cliente", cliente);
		
		vista = new ModelAndView(viewModel, "admin.hbs");
		return vista; //esta vista es la misma que antes pero con la tablita completa con consumos
		//y el id del usuario en el texto
	}
	

	public ModelAndView mostrarAltaDispositivo(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = request.queryParams("NUMERODECLIENTE");
		
		if(id.isEmpty()) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "admin.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			viewModel.put("cliente", cliente);
			vista = new ModelAndView(viewModel, "altaDispositivo.hbs");
		}
		return vista;
	}
	
	public ModelAndView altaDispositivo(Request request, Response response) throws IOException { //falta implementar
		ModelAndView vista = null;
		return vista;
	}
	
	public ModelAndView reportes(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = request.queryParams("NUMERODECLIENTE");
		
		if(id.isEmpty()) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "admin.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			viewModel.put("cliente", cliente);
			vista = new ModelAndView(viewModel, "reportes.hbs");
		}
		return vista;
	}
}