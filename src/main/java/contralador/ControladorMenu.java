package contralador;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorMenu implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrarMenu(Request request, Response response) {
		System.out.println("Mostrar Menu");
		System.out.println(request.body());
		System.out.println(request.attributes());
		return new ModelAndView(null, "menu.hbs");
	}

}
