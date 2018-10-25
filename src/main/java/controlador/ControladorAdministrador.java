package controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import repositorio.RepositorioDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Cliente;

public class ControladorAdministrador extends ControladorUsuario{

	public RepositorioDeUsuarios repoDeUsuarios = RepositorioDeUsuarios.getInstancia();
	private static ControladorAdministrador instancia = null;
	Cliente cliente;

	public static ControladorAdministrador getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAdministrador();
		}
		return instancia;
	}
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		return new ModelAndView(null , "admin.hbs");
	}

	public ModelAndView infoUsuario(Request request, Response response) {
		String id = request.params(":id");
		
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		
		if(id.length() == 0) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			viewModel.put("error", error); //seria un cartelito de "Por favor, ingrese un id"
			//response.redirect("/admin"); //o puedo redireccionar a la pag que ya estaba y fue
			vista =  new ModelAndView(viewModel , "admin.hbs");
			return vista;
		}
		
		System.out.printf("El id ingresado es: ", id);
		
		cliente = repoDeUsuarios.recuperarUsuarioPorIdDeUsuario(Integer.valueOf(id)); //implementar:)
		//chequear que pasa cuando no encuentra el usuario ..
		viewModel.put("cliente", cliente);
		
		vista = new ModelAndView(viewModel, "admin.hbs");
		return vista; //esta vista es la misma que antes pero con la tablita completa con consumos
		//y el id del usuario en el texto
	}

	//public ModelAndView altaDispositivo(Request req, Response res) throws IOException {
		
	//}
}