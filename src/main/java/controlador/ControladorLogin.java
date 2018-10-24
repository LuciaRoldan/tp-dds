package controlador;

import com.github.jknack.handlebars.Handlebars;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControladorLogin implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {

		String error="Error combinacion de usuario y contraseña invalidos";

		System.out.println(request.body());
		if(request.body().equals("user=1234&password=1234")) {
			response.redirect("/usuario");
			return new ModelAndView(null, "usuario.hbs");
		}else {
			response.status(400);
			Map<String, Object> viewModel = new HashMap<>();
			viewModel.put("error",error);
			return new ModelAndView(viewModel , "login.hbs");
		}
	}
}
