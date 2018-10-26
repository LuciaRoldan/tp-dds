package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import com.sun.org.apache.xpath.internal.operations.Bool;

import dispositivo.DispositivoFactory;
import dispositivosConcretos.DispositivoConcreto;
import repositorio.RepositorioDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Cliente;
import usuario.Usuario;

public class ControladorAdministrador extends ControladorUsuario{

	public RepositorioDeUsuarios repoDeUsuarios = RepositorioDeUsuarios.getInstancia();
	Cliente cliente;
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		return new ModelAndView(null , "admin.hbs");
	}
	
	public String parsearId(String body) {
		String id = null;
		if(body.split("=").length > 1) {
			id = Arrays.asList(body.split("=")).get(1);
		}
		return id;
	}

	public ModelAndView infoUsuario(Request request, Response response) {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = "0";
		id = request.queryParams("NUMERODECLIENTE");
		
		System.out.printf(id);
		
		if(id.length() < 1 || id.equals("0")) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "admin.hbs");
			return vista;
		} else {

			System.out.printf("El id ingresado es: " + id);

			cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			//chequear que pasa cuando no encuentra el usuario ..
			viewModel.put("cliente", cliente);

			vista = new ModelAndView(viewModel, "admin.hbs");
			return vista; //esta vista es la misma que antes pero con la tablita completa con consumos
		}
	}
	

	public ModelAndView mostrarAltaDispositivo(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = "0";
		if(request.queryParamOrDefault("NUMERODECLIENTE", "0") != "0") {
			id = request.queryParams("NUMERODECLIENTE");
		}
		
		if(id.length() < 1 || id.equals("0")) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "adminAlta.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			viewModel.put("cliente", cliente);
			vista = new ModelAndView(viewModel, "adminAlta.hbs");
			return vista;
		}
		
	}
	
	public ModelAndView reportes(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = "0";
		id = request.queryParams("NUMERODECLIENTE");
		
		if(id.length() < 1 || id.equals("0")) {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "adminReportes.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			viewModel.put("cliente", cliente);
			vista = new ModelAndView(viewModel, "adminReportes.hbs");
			return vista;
		}
	}
	
/*	public ModelAndView altaDispositivo(Request request, Response response) throws IOException { //falta implementar
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String id = "0";
		id = request.queryParams("NUMERODECLIENTE");
		
		if(id.length() < 1 || id == "0") {
			System.out.printf("No me ingresaron ningun id");
			//response.status(400);
			String error = "Ingrese un ID";
			viewModel.put("error", error);
			vista =  new ModelAndView(viewModel , "adminAlta.hbs");
			return vista;
		}else {

			System.out.printf("El id ingresado es: ", id);

			cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));

			viewModel.put("cliente", cliente);
			vista = new ModelAndView(viewModel, "adminAlta.hbs");
			return vista;
		}
	}
*/
	
	//-----AIRE-----
	public ModelAndView mostrarAltaAire(Request request, Response response) throws IOException {
		ModelAndView vista = new ModelAndView(null, "adminAltaAire.hbs");
		return vista;
	}
	
	public ModelAndView altaAire(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		
		if(p.get(0).length() != 0 || p.get(1).length() != 0) {
		
			String nombre = Arrays.asList(p.get(0).split("=")).get(1);
			String frigorias = Arrays.asList(p.get(1).split("=")).get(1);
		
			DispositivoFactory factory = new DispositivoFactory();
			factory.setNombre(nombre);
		
			DispositivoConcreto aireAcondicionado = factory.crearAireAcondicionado(Integer.valueOf(frigorias));
			//cliente.agregarDispositivo(aireAcondicionado);
		
			viewModel.put("exito", exito);
			vista = new ModelAndView(viewModel, "adminAlta.hbs");
			return vista;
		}
		else {
			String error = "Ingrese todos los datos";
			viewModel.put("error", error);
			vista = new ModelAndView(viewModel, "adminAltaAire.hbs");
			return vista;
		}
	}
	
	//-----HELADERA-----
	public ModelAndView altaHeladeraConFreezer(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		String nombre = Arrays.asList(request.body().split("=")).get(1);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre(nombre);
		
		DispositivoConcreto heladeraConFreezer = factory.crearHeladeraConFreezer();
		//cliente.agregarDispositivo(heladeraConFreezer);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;
	}
	
	public ModelAndView altaHeladeraSinFreezer(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		String nombre = Arrays.asList(request.body().split("=")).get(1);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre(nombre);
		
		DispositivoConcreto heladeraSinFreezer = factory.crearHeladeraSinFreezer();
		//cliente.agregarDispositivo(heladeraSinFreezer);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;
	}
	
	//-----LAMPARA-----
	public ModelAndView mostrarAltaHalogena(Request request, Response response) throws IOException {
		ModelAndView vista = new ModelAndView(null, "adminAltaHalogena.hbs");
		return vista;
	}
	
	public ModelAndView altaHalogena(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String w = Arrays.asList(p.get(1).split("=")).get(1);
		String horasMensuales = Arrays.asList(p.get(2).split("=")).get(1);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre(nombre);
		factory.setHorasUsoMensuales(Integer.valueOf(horasMensuales));
		
		DispositivoConcreto lamparaHalogena = factory.crearLamparaHalogena(Integer.valueOf(w));
		//cliente.agregarDispositivo(lamparaHalogena;
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;		
	}
	
	public ModelAndView mostrarAltaLamparaComun(Request request, Response response) throws IOException {
		ModelAndView vista = new ModelAndView(null, "adminAltaLamparaComun.hbs");
		return vista;
	}
	
	public ModelAndView altaLamparaComun(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String w = Arrays.asList(p.get(1).split("=")).get(1);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre(nombre);
		
		DispositivoConcreto lamparaComun = factory.crearLamparaComun(Integer.valueOf(w));
		//cliente.agregarDispositivo(lamparaComun);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;		
	}
	
	//-----LAVARROPAS-----
	public ModelAndView mostrarAltaLavarropasAutomatico(Request request, Response response) throws IOException {
		ModelAndView vista = new ModelAndView(null, "adminAltaLavarropasAutomatico.hbs");
		return vista;
	}
	
	public ModelAndView altaLavarropasAutomatico(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String calentamiento = Arrays.asList(p.get(1).split("=")).get(1);
		String capacidad = Arrays.asList(p.get(2).split("=")).get(1);
		
		
		DispositivoFactory factory = new DispositivoFactory();
		
		boolean tieneCalentamiento = calentamiento.equals("Si");
		
		if(tieneCalentamiento) {
			String horasMensuales = Arrays.asList(p.get(3).split("=")).get(1);
			factory.setHorasUsoMensuales(Integer.valueOf(horasMensuales));
		}
		factory.setNombre(nombre);
		
		DispositivoConcreto lavarropasAutomatico = factory.crearLavarropasAutomatico(tieneCalentamiento, Integer.valueOf(capacidad));
		//cliente.agregarDispositivo(lavarropasAutomatico);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;		
	}
	
	public ModelAndView mostrarAltaLavarropasSemiAutomatico(Request request, Response response) throws IOException {
		ModelAndView vista = new ModelAndView(null, "adminAltaLavarropasAutomatico.hbs");
		return vista;
	}
	
	public ModelAndView altaLavarropasSemiAutomatico(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String calentamiento = Arrays.asList(p.get(1).split("=")).get(1);
		String capacidad = Arrays.asList(p.get(2).split("=")).get(1);
		String horasMensuales = Arrays.asList(p.get(3).split("=")).get(1);
		
		boolean tieneCalentamiento = calentamiento.equals("Si");
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setHorasUsoMensuales(Integer.valueOf(horasMensuales));
		factory.setNombre(nombre);
		
		DispositivoConcreto lavarropasSemiAutomatico = factory.crearLavarropasSemiAutomatico(tieneCalentamiento, Integer.valueOf(capacidad));
		//cliente.agregarDispositivo(lavarropasSemiAutomatico);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;
	}
	
	//-----Microondas-----
	public ModelAndView altaMicroondas(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String horasMensuales = Arrays.asList(p.get(1).split("=")).get(1);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setHorasUsoMensuales(Integer.valueOf(horasMensuales));
		factory.setNombre(nombre);
		
		DispositivoConcreto microondas = factory.crearMicroondas();
		//cliente.agregarDispositivo(microondas);
		
		viewModel.put("exito", exito);
		vista = new ModelAndView(viewModel, "adminAlta.hbs");
		return vista;
	}
	
	//-----PC-----
	public ModelAndView altaPC(Request request, Response response) throws IOException {
		ModelAndView vista = null;
		Map<String, Object> viewModel = new HashMap<>();
		String exito = "Dispositivo agregado correctamente";
		
		List<String> p = Arrays.asList(request.body().split("&"));
		String nombre = Arrays.asList(p.get(0).split("=")).get(1);
		String horasMensuales = Arrays.asList(p.get(1).split("=")).get(1);
		
		if(p.get(0).length() != 0 || p.get(1).length() != 0) {
		
			DispositivoFactory factory = new DispositivoFactory();
			factory.setHorasUsoMensuales(Integer.valueOf(horasMensuales));
			factory.setNombre(nombre);
			
			DispositivoConcreto pc = factory.crearPC();
			//cliente.agregarDispositivo(pc);
		
			viewModel.put("exito", exito);
			vista = new ModelAndView(viewModel, "adminAlta.hbs");
			return vista;
		} else {
			String error = "Ingrese todos los datos";
			viewModel.put("error", error);
			vista = new ModelAndView(viewModel, "adminAltaPC.hbs");
			return vista;
		}
	}
	
}