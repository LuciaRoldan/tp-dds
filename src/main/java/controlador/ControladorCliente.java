package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

import dispositivosConcretos.DispositivoConcreto;
import sensor.Sensor;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Cliente;

public class ControladorCliente extends ControladorUsuario {
	
	Cliente cliente = null;
	String id;
	String inicio;
	String fin;
	
	
	public ModelAndView mostrar(Request request, Response response) throws IOException {
		id = request.params(":id");
		cliente = (Cliente) repoDeUsuarios.recuperarUsuarioPorId(Integer.valueOf(id));
		String fechaFin = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-mm")).toString();
		Calendar calendario = Calendar.getInstance();   // this takes current date
		String fechaInicio;
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd-mm");
		fechaInicio = format1.format(calendario.getTime());
		String periodo =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd"));

		HashMap<String, Object> viewModel = new HashMap<>();
		viewModel.put("cliente",cliente);
		viewModel.put("fechaInicio",fechaInicio);
		viewModel.put("fechaFin",fechaFin);
		viewModel.put("periodo",periodo);

		return new ModelAndView(viewModel , "usuario.hbs");
	}
	
	public ModelAndView ejecutarSimplex(Request request, Response response) throws IOException {

		HashMap<String, Object> viewModel = new HashMap<String,Object>();
		HashMap<DispositivoConcreto, Double> listaDispositivos = new HashMap<DispositivoConcreto,Double>();
		listaDispositivos = cliente.configuracionOptima();
		List<DispositivoConcreto> list = new ArrayList<DispositivoConcreto>(listaDispositivos.keySet());
		viewModel.put("listaDispositivos",list);
		viewModel.put("cliente",cliente);
		System.out.println(listaDispositivos.toString());
		
		return new ModelAndView(viewModel, "usuarioSimplex.hbs");
	}
	
	public ModelAndView mostrarEstadoDispositivos(Request request, Response response) throws IOException {
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		List<DispositivoConcreto> listaDispositivos = cliente.getDispositivosInteligentes(); //Cambie dispositivos por dispositivos inteligentes
		viewModel.put("listaDispositivos",listaDispositivos);
		viewModel.put("cliente",cliente);

		return new ModelAndView(viewModel,"usuarioEstados.hbs");
	}
	
	public ModelAndView mostrarMediciones(Request request, Response response) throws IOException {

		
		HashMap<String, Object> viewModel = new HashMap<>();
		List<Sensor> listaMediciones = new ArrayList<>();
		
		for (Sensor sensor : cliente.getSensores()) {
			listaMediciones.add(sensor);
		}
		viewModel.put("listaMediciones",listaMediciones);
		viewModel.put("cliente",cliente);

		System.out.println(listaMediciones.size());

		return new ModelAndView(viewModel,"usuarioUltimas.hbs");
		
	}
	
	public ModelAndView calcularConsumoEnPeriodo(Request request, Response response) throws IOException {
		
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		inicio = request.queryParams("fechaInicio");
		fin = request.queryParams("fechaFin");
		
		LocalDateTime fechaInicio = parsearFecha(inicio).atStartOfDay();
		LocalDateTime fechaFin = parsearFecha(fin).atStartOfDay();
		
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		
		Double consumo = cliente.calcularConsumoPeriodo(fechaInicio, fechaFin);
		
		viewModel.put("consumo", consumo);

		response.redirect("/usuario/" + id);
		return new ModelAndView(null, "usuarioConsumo.hbs");
	}
	
	private LocalDate parsearFecha(String fecha) {
		 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        
	        LocalDate localDate = LocalDate.parse(fecha, formatter);
	 
	        return localDate;

	    }
	}

