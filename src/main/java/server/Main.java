package server;

import static spark.Spark.*;

import controlador.*;
import controlador.ControladorInicio;
import controlador.ControladorMenu; 
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkUtils.HandlebarsTemplateEngineBuilder;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) {
    	port(8003);
    	
    	HandlebarsTemplateEngineBuilder builder = new HandlebarsTemplateEngineBuilder(new HandlebarsTemplateEngine());
    	DebugScreen.enableDebugScreen();
    	
    	ControladorInicio home = new ControladorInicio();
    	ControladorMenu menu = new ControladorMenu();
    	ControladorUsuario controladorUsuario = new ControladorUsuario();
		ControladorMap map = new ControladorMap();
		ControladorAdministrador controladorAdmin = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
    	
    	//HandlebarsTemplateEngine engine = builder.build();

		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    	
    	Init init = new Init();
    	
    	staticFileLocation("/templates");
        //PANTALLA DE INICIO
        get("/", home::mostrar, engine);

        //LOGIN SE ENCARGA DE VALIDAR EL LOGIN Y LLEVAR AL MENU
        post("/login", controladorUsuario::buscarUsuario,engine);
		get("/login", controladorUsuario::buscarUsuario,engine); //por que hay un get?? hce lo mismo q el post?
		get("/map", map::mostrar,engine);


        get("/usuario", controladorCliente::mostrar, engine);
        
        //ADMIN
        get("/admin", controladorAdmin::mostrar, engine);
        get("/user/:id", controladorAdmin::infoUsuario, engine);
        
        //get("/usuario/id/alta", controladorAdmin::altaDispositivo, engine);
        
    }


}