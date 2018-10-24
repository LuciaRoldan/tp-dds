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

public class ControladorUsuario implements WithGlobalEntityManager, TransactionalOps{

	public ModelAndView mostrar(Request request, Response response) throws IOException {

		return new ModelAndView(null , "usuario.hbs");
	}

}