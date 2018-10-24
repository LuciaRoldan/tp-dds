package controlador;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorMap implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request request, Response response) {
		System.out.println(request.body());
		return new ModelAndView(null, "map.hbs");
	}

}
