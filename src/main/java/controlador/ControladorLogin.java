package controlador;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.sun.javafx.collections.MappingChange.Map;

import repositorio.RepositorioDeUsuarios;

import org.hsqldb.lib.HashMap;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.util.Arrays;

public class ControladorLogin implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		System.out.println(request.body());
		String p = Arrays.asList(request.body().split("&")).get(0);
		String user = Arrays.asList(p.split("=")).get(1);
		
		String p2 = Arrays.asList(request.body().split("&")).get(1);
		String pass = Arrays.asList(p2.split("=")).get(1);
	
		System.out.println(user);
		System.out.println(pass);
		
		if(RepositorioDeUsuarios.getInstancia().isLoginValido(user, pass)) {
		//if(request.body().equals("user=1234&password=1234")) {
			System.out.println("Info correcta!");
			response.redirect("/inicio");
			return new ModelAndView(null, "inicio.hbs");
		}else {
			HashMap<String, Object> viewModel = new HashMap<String, Object>();
			String error = "ERROR CONTRASEÑA INCONRRECTA";
			viewModel.put(error);
			//Template template = handlebars.compileInline("login.hbs","{{error}}","ERROR");
			return new ModelAndView(error, "login.hbs");
		}
	}

}
