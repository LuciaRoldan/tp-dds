package menu;

import static spark.Spark.*;

<<<<<<< HEAD
import controlador.ControladorInicio;
import controlador.ControladorLogin;
import controlador.ControladorMenu;
=======
import contralador.ControladorLogin;
import contralador.ControladorMenu;
import contralador.ControladorUsuario;
>>>>>>> ae2f43ddbfaadfc61d9e5afb6ed1c3d5860a61b9
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkUtils.HandlebarsTemplateEngineBuilder;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) {
    	port(8000);
    	
    	HandlebarsTemplateEngineBuilder builder = new HandlebarsTemplateEngineBuilder(new HandlebarsTemplateEngine());
    	DebugScreen.enableDebugScreen();
    	
    	ControladorLogin login = new ControladorLogin();
    	ControladorInicio home = new ControladorInicio();
    	ControladorMenu menu = new ControladorMenu();
    	ControladorUsuario usuario = new ControladorUsuario();
    	
    	HandlebarsTemplateEngine engine = builder.build(); 
    	
    	staticFileLocation("/templates");
<<<<<<< HEAD

        //PANTALLA DE INICIO
        get("/", home::mostrar, engine);

        //LOGIN SE ENCARGA DE VALIDAR EL LOGIN Y LLEVAR AL MENU
        post("/login", login::mostrar);

        get("/usuario", menu::mostrar, engine);
=======
		
        get("/hola", (req, res) -> "Hola amiguitos");
        
        get("/", home::mostrar, engine);
        //get("/usuario", ControladorUsuario::mostrar, engine);
        
>>>>>>> ae2f43ddbfaadfc61d9e5afb6ed1c3d5860a61b9
    }
}