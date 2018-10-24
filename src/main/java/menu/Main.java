package menu;

import static spark.Spark.*;

import contralador.ControladorLogin;
import contralador.ControladorMenu;
import contralador.ControladorUsuario;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkUtils.HandlebarsTemplateEngineBuilder;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) {
    	port(8000);
    	
    	HandlebarsTemplateEngineBuilder builder = new HandlebarsTemplateEngineBuilder(new HandlebarsTemplateEngine());
    	DebugScreen.enableDebugScreen();
    	
    	ControladorLogin home = new ControladorLogin();
    	ControladorMenu menu = new ControladorMenu();
    	ControladorUsuario usuario = new ControladorUsuario();
    	
    	HandlebarsTemplateEngine engine = builder.build(); 
    	
    	staticFileLocation("/templates");
		
        get("/hola", (req, res) -> "Hola amiguitos");
        
        get("/", home::mostrar, engine);
        //get("/usuario", ControladorUsuario::mostrar, engine);
        
    }
}