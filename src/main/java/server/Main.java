package server;

import static spark.Spark.*;

import controlador.*;
import controlador.ControladorInicio;
import controlador.ControladorMenu;
import repositorio.MockDB;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkUtils.HandlebarsTemplateEngineBuilder;
import spark.debug.DebugScreen;

public class Main {
    public static void main(String[] args) {
    	port(8000);

    	MockDB baseDeDatos = new MockDB();
    	baseDeDatos.inicializarDB();
    	
    	DebugScreen.enableDebugScreen();
    	
    	ControladorInicio home = new ControladorInicio();
    	ControladorMenu menu = new ControladorMenu();
    	ControladorUsuario controladorUsuario = new ControladorUsuario();
		ControladorMap map = new ControladorMap();
		ControladorAdministrador controladorAdmin = new ControladorAdministrador();
		ControladorCliente controladorCliente = new ControladorCliente();
    	
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    	staticFileLocation("/templates");
        //PANTALLA DE INICIO
        get("/", home::mostrar, engine);

        //LOGIN SE ENCARGA DE VALIDAR EL LOGIN Y LLEVAR AL MENU
        post("/login", controladorUsuario::buscarUsuario,engine);
		get("/login", controladorUsuario::buscarUsuario,engine);
		get("/usuario/:id", controladorCliente::mostrar, engine);
		get("/usuarioSimplex", controladorCliente::ejecutarSimplex, engine);
		get("/usuarioEstados", controladorCliente::mostrarEstadoDispositivos, engine);
		get("/usuarioUltimas", controladorCliente::mostrarMediciones, engine);
		get("/logout", home::mostrar, engine);

        	
        //ADMIN|        
        get("/admin", controladorAdmin::mostrar, engine);
        get("/admin/informacion", controladorAdmin::infoUsuario, engine);
        get("/admin/reportes", controladorAdmin::reportes, engine);
        get("/admin/altaDispositivo", controladorAdmin::mostrarAltaDispositivo, engine);
        
        //---altas        
        //aire
        get("/admin/altaDispositivo/aireAcondicionado", controladorAdmin::mostrarAltaAire, engine);
        post("/admin/altaDispositivo/aireAcondicionado", controladorAdmin::altaAire, engine);
        //heladeras
        post("/admin/altaDispositivo/heladeraConFreezer", controladorAdmin::altaHeladeraConFreezer, engine);
        post("/admin/altaDispositivo/heladeraSinFreezer", controladorAdmin::altaHeladeraSinFreezer, engine);
        //lamparas
        get("/admin/altaDispositivo/lamparaHalogena", controladorAdmin::mostrarAltaHalogena, engine);
        post("/admin/altaDispositivo/lamparaHalogena", controladorAdmin::altaHalogena, engine);
        get("/admin/altaDispositivo/lamparaComun", controladorAdmin::mostrarAltaHalogena, engine);
        post("/admin/altaDispositivo/lamparaComun", controladorAdmin::altaHalogena, engine);
        //lavarropas
        get("/admin/altaDispositivo/lavarropasAtomatico", controladorAdmin::mostrarAltaHalogena, engine);
        post("/admin/altaDispositivo/lavarropasAutomatico", controladorAdmin::altaHalogena, engine);
        get("/admin/altaDispositivo/lavarropasSemiAutomatico", controladorAdmin::mostrarAltaHalogena, engine);
        post("/admin/altaDispositivo/lavarropasSemiAutomatico", controladorAdmin::altaHalogena, engine);
        //microondas
        post("/admin/altaDispositivo/microondas", controladorAdmin::altaMicroondas, engine);
        //pc
        post("/admin/altaDispositivo/pc", controladorAdmin::altaPC, engine);

    }


}