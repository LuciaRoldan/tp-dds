package controlador;

import java.io.IOException;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorAdministrador extends ControladorUsuario{

	public ModelAndView mostrar(Request request, Response response) throws IOException {

		return new ModelAndView(null , "admin.hbs");
	}

}