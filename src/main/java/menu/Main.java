package menu;

import static spark.Spark.*;

import controlador.ControladorInicio;
import controlador.ControladorLogin;
import controlador.ControladorMenu;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
    public static void main(String[] args) {
    	port(8080);
    	
    	HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    	
    	ControladorLogin login = new ControladorLogin();
    	ControladorInicio home = new ControladorInicio();
    	ControladorMenu menu = new ControladorMenu();
    	
    	staticFileLocation("/templates");

        //PANTALLA DE INICIO
        get("/", home::mostrar, engine);

        //LOGIN SE ENCARGA DE VALIDAR EL LOGIN Y LLEVAR AL MENU
        post("/login", login::mostrar);

        get("/usuario", menu::mostrar, engine);
    }
}