package controlador;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorInicio implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request request, Response response) {
		System.out.println("Mostrar Login");
		return new ModelAndView(null, "login.hbs");
	}

}
