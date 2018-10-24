package contralador;

import spark.ModelAndView;

public class ControladorUsuario {

	public ControladorUsuario() {}
	
	public ModelAndView mostrar() {
		return new ModelAndView(null, "usuario.hbs");
	}
}
