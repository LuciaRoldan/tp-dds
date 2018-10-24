package ui;

import static spark.Spark.*;
import static spark.Spark.post;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {

  public static void main(String[] args) {
    System.out.println("Iniciando servidor");

    //HomeController home = new HomeController();
    HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
    
    Spark.port(8080);

    Spark.staticFiles.externalLocation(System.getProperty("user.dir") + "/resources/public");
    //staticFileLocation("/public");
   // DebugScreen.enableDebugScreen();

    //get("/", home::mostrar, engine);

    get("/hello", (req, res) -> "Hello");
    
    get("/index.html", (request, response) -> {
      response.redirect("/");
      return null;
    });
    //get("/consultoras", consultoras::listar, engine);
    //post("/consultoras", consultoras::crear);
    //get("/consultoras/new", consultoras::nuevo, engine);
    //get("/consultoras/:id", consultoras::mostrar, engine);

  }

}
