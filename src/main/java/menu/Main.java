package menu;

import static spark.Spark.*;

import controlador.ControladorInicio;
import controlador.ControladorLogin;
import controlador.ControladorMenu;
import controlador.ControladorUsuario;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkUtils.HandlebarsTemplateEngineBuilder;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) {
    	port(8080);
    	
    	HandlebarsTemplateEngineBuilder builder = new HandlebarsTemplateEngineBuilder(new HandlebarsTemplateEngine());
    	DebugScreen.enableDebugScreen();
    	
    	ControladorLogin login = new ControladorLogin();
    	ControladorInicio home = new ControladorInicio();
    	ControladorMenu menu = new ControladorMenu();
    	ControladorUsuario controladorUsuario = new ControladorUsuario();
    	
    	//HandlebarsTemplateEngine engine = builder.build();

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    	
    	staticFileLocation("/templates");


        //PANTALLA DE INICIO
        get("/", home::mostrar, engine);

        //LOGIN SE ENCARGA DE VALIDAR EL LOGIN Y LLEVAR AL MENU
        post("/login", login::mostrar,engine);
		get("/login", login::mostrar,engine);


        get("/usuario", controladorUsuario::mostrar, engine);
        

    }


}