package controlador;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;

public class ControladorLogin implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		System.out.println(request.body());
		if(request.body().equals("user=1234&password=1234")) {
			response.redirect("/inicio");
			return new ModelAndView(null, "inicio.hbs");
		}else {
			response.redirect("/");
			Handlebars handlebars = new Handlebars();
			String error = "ERROR";
			//Template template = handlebars.compileInline("login.hbs","{{error}}","ERROR");
			return new ModelAndView(error, "login.hbs");
		}
	}

}
