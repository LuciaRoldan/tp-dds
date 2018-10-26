package controlador;

import java.io.IOException;
import java.util.HashMap;

import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Cliente;

public class ControladorCliente extends ControladorUsuario {
	
	Cliente cliente = null;
	String id;
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		id = request.params(":id");
		cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));
 		return new ModelAndView(null , "usuario.hbs");
	}
	
	public ModelAndView ejecutarSimplex(Request request, Response response) throws IOException {
		System.out.println("Entre a ejecutar");
		HashMap<DispositivoConcreto, Double> configuracionOptima = new HashMap<DispositivoConcreto, Double>();

		configuracionOptima = cliente.configuracionOptima();
		System.out.println(configuracionOptima.toString());
		
		response.redirect("/usuarioSimplex");
		return new ModelAndView(null, "usuarioSimplex.hbs");
	}
	
//	public ModelAndView mostrarSimplex(Request request, Response response) throws IOException {
//		System.out.println("Entre a mostrar");
//		response.redirect("/usuarioSimplex");
//		return new ModelAndView(null, "usuarioSimplex.hbs");
//	}
	
	public ModelAndView mostrarEstadoDispositivos(Request request, Response response) throws IOException {
		HashMap<DispositivoConcreto, EstadoDispositivo> estadosDeDispositivos = new HashMap<DispositivoConcreto, EstadoDispositivo>();
		for (DispositivoConcreto dispo : cliente.getDispositivos()) {
			estadosDeDispositivos.put(dispo, dispo.getEstado());
		}
		System.out.println(estadosDeDispositivos.toString());
		
		response.redirect("/estados");
		return new ModelAndView(estadosDeDispositivos,"usuarioEstados.hbs");
	}
	
	
//	private HashMap<DispositivoConcreto, EstadoDispositivo> mapearEstadosDispositivos(){
//		HashMap<DispositivoConcreto, EstadoDispositivo> estadosDeDispositivos = new HashMap<DispositivoConcreto, EstadoDispositivo>();
//		for (DispositivoConcreto dispo : cliente.getDispositivos()) {
//			estadosDeDispositivos.put(dispo, dispo.getEstado());
//		}
//		return estadosDeDispositivos;
//	}

}
