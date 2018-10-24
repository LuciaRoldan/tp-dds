package menu;

import static spark.Spark.*;

import contralador.ControladorLogin;
import contralador.ControladorMenu;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Main {
    public static void main(String[] args) {
    	port(8080);
    	
    	HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    	
    	ControladorLogin home = new ControladorLogin();
    	ControladorMenu menu = new ControladorMenu();
    	
    	staticFileLocation("/templates");
		
        get("/hola", (req, res) -> "Hola amiguitos");
        get("/", home::mostrar, engine);
        post("/menu", menu::mostrarMenu, engine);
    }
}