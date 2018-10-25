package controlador;

import java.io.IOException;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ControladorCliente extends ControladorUsuario {
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
 		return new ModelAndView(null , "cliente.hbs");
	}

}
