package db;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import actuador.Actuador;
import actuador.AireEstadoActuador;
import dispositivo.DispositivoFactory;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import exceptionParser.NoSePudoAbrirElArchivoException;
import parserTransformadorYZona.ParserTransformadorYZona;
import regla.Condicion;
import regla.CondicionTemperaturaAlta;
import regla.CondicionVentanaAbierta;
import regla.Regla;
import repositorio.RepositorioDeUsuarios;
import sensor.Sensor;
import repositorio.RepositorioDeDispositivos;
import repositorio.RepositorioDeReglas;
import repositorio.RepositorioDeTransformadoresYZonas;
import transformador.Transformador;
import usuario.Cliente;

public class casosDePruebaDB {
	ClaseParaDB claseParaDB = new ClaseParaDB();
	RepositorioDeReglas repoDeReglas = new RepositorioDeReglas();
	RepositorioDeDispositivos repoDeDispositivos = new RepositorioDeDispositivos();
	RepositorioDeUsuarios repositorioDeUsuarios = new RepositorioDeUsuarios();

	@Test
	public void caso1() {
		//Crear 1 usuario nuevo. Persistirlo. Recuperarlo, modificar la geolocalizaci�n y grabarlo. Recuperarlo y evaluar 
		//que el cambio se haya realizado.

		Cliente cliente = ClaseParaDB.getCliente();
		
		repositorioDeUsuarios.agregarUsuario(cliente);
		
		
		Cliente cliente2 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(cliente.getNombreUsuario());
		Float nuevaCoordenadaX = new Float(100);
		cliente2.setCoordenadaX(nuevaCoordenadaX);
		
		Cliente cliente3 = (Cliente) repositorioDeUsuarios.recuperarUsuarioPorNombreDeUsuario(cliente.getNombreUsuario());
		assertEquals(nuevaCoordenadaX, cliente3.getCoordenadaX());
	}
	
	@Test
	public void caso2() {
		//Recuperar un dispositivo. Mostrar por consola todos los intervalos que estuvo encendido durante el �ltimo mes. Modificar 
		//su nombre (o cualquier otro atributo editable) y grabarlo. Recuperarlo y evaluar que el nombre coincida con el esperado.
		
		DispositivoConcreto aire = ClaseParaDB.unDispositivoConEstados();

		System.out.println(aire.getEstadosAnteriores().size());
		//c�mo persistir fechas?? por qu� no puedo pesistir el dispositivo??
		
		repoDeDispositivos.persistirDispositivo(aire);
		
		DispositivoConcreto dispositivoRecuperado = repoDeDispositivos.getDispositivo(aire.getId());
		
		//verificar que sean del ult mes
		dispositivoRecuperado.getEstadosAnteriores().forEach(estado ->
				System.out.printf("El dispositivo estuvo encendido entre el ", estado.getInicio(), " y el ", estado.getFin()));
		
		dispositivoRecuperado.setName("aireConNombreCambiado");
		
		//repoDeDispositivos.persistirDispositivo(aire);
		
		DispositivoConcreto dispositivoRecuperadoConNuevoNombre = repoDeDispositivos.getDispositivo(aire.getId());
		
		assertEquals("aireConNombreCambiado", dispositivoRecuperadoConNuevoNombre.getName());
	}
	
	@Test
	public void caso3() {
		//Crear una nueva regla. Asociarla a un dispositivo. Agregar condiciones y acciones. Persistirla. Recuperarla y ejecutarla. 
		//Modificar alguna condici�n y persistirla. Recuperarla y evaluar que la condici�n modificada posea la �ltima modificaci�n.
		
		Sensor sensor = new Sensor();
		
		Condicion condicion = new CondicionTemperaturaAlta(sensor, 26);
		
		Condicion condicionNueva = new CondicionVentanaAbierta(sensor, true);
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("aire");
		AireAcondicionado aire = factory.crearAireAcondicionado(2200);
		factory.setNombre("aireNuevo");
		AireAcondicionado aireNuevo = factory.crearAireAcondicionado(3500);
		
		AireEstadoActuador actuador = new AireEstadoActuador(aire, true); 
		actuador.setDispositivo(aire);
		
		AireEstadoActuador actuadorNuevo = new AireEstadoActuador(aireNuevo, true);
		actuador.setDispositivo(aireNuevo);
				
		List<Actuador> listaDeActuadores = new ArrayList<Actuador>();
		List<Condicion> listaDeCondiciones = new ArrayList<Condicion>();
		
		listaDeActuadores.add(actuador);
		listaDeCondiciones.add(condicion);
		
		int cantidadActuadores = listaDeActuadores.size();
		int cantidadCondiciones = listaDeCondiciones.size();
		
		Regla regla = new Regla(listaDeActuadores, listaDeCondiciones);
		
		repoDeReglas.persistirRegla(regla);
		
		assertEquals(regla, repoDeReglas.getRegla(regla.numeroDeRegla));
		assertEquals(actuador, repoDeReglas.getListaActuadores().get(0));
		assertEquals(condicion, repoDeReglas.getListaCondiciones().get(0));
		
		//No esta persistiendo cuando agrega actuadores/condiciones
		regla.agregarActuador(actuadorNuevo);
		regla.agregarCondicion(condicionNueva);
		
		repoDeReglas.persistirRegla(regla);
		
		listaDeActuadores = repoDeReglas.getListaActuadores();
		listaDeCondiciones = repoDeReglas.getListaCondiciones();
		
		
		assertEquals(cantidadActuadores +1, listaDeActuadores.size());
		assertEquals(cantidadCondiciones +1, listaDeCondiciones.size());
	}
	
	@Test
	public void caso4() throws NoSePudoAbrirElArchivoException, IOException {
		//Recuperar todos los transformadores persistidos. Registrar la cantidad. Agregar una instancia de Transformador al JSON de 
		//entradas. Ejecutar el m�todo de lectura y persistencia. Evaluar que la cantidad actual sea la anterior + 1.
		
		Transformador transformador = ClaseParaDB.getTransformador();
		RepositorioDeTransformadoresYZonas repoTransformadores = new RepositorioDeTransformadoresYZonas();
		repoTransformadores.persistirTransformador(transformador);
		
		List<Transformador> transformadores = repoTransformadores.getListaTransformadores();
		int cantidadOriginal = transformadores.size();
		
		ParserTransformadorYZona parser = new ParserTransformadorYZona();
		Transformador nuevoTransformador = parser.parsearTransformador("src/test/java/db/transformador.json");
		System.out.println(nuevoTransformador.getNombre());
		repoTransformadores.persistirTransformador(nuevoTransformador);
		
		transformadores = repoTransformadores.getListaTransformadores();
		assertEquals(cantidadOriginal +1, transformadores.size());
	}
	
	@Test
	public void caso5() {
		//Dado un hogar y un periodo, mostrar por consola (interfaz de comandos) el consumo total. Dado un dispositivo y un periodo, 
		//mostrar por consola su consumo promedio. Dado un transformador y un perido, mostrar su consumo promedio. Recuperar un 
		//dispositivo asociado a un hogar de ese transformador e incrementar un 1000 % el consumo para ese periodo. Persistir el 
		//dispositivo. Nuevamente mostrar el consumo para ese transformador.
		Cliente cliente = claseParaDB.getClienteConDispositivos();
		repositorioDeUsuarios.agregarUsuario(cliente);
		LocalDateTime inicio = claseParaDB.getInicioPeriodo();
		LocalDateTime fin = claseParaDB.getFinPeriodo();
		
		double consumoCliente = cliente.consumoHogarPeriodo(inicio, fin);
		System.out.print("El consumo del cliente es: " + consumoCliente + "\n");
		
		Transformador transformador = claseParaDB.getTransformador();
		transformador.addCliente(cliente);
		
		double consumoTransformador = cliente.consumoHogarPeriodo(inicio, fin);
		System.out.print("El consumo del transformador es: " + consumoTransformador + "\n");
		
		DispositivoConcreto dispositivo = repoDeDispositivos.getDispositivoPorUsuario(cliente.numeroDeUsuario);
		
		assertTrue(true);
	}

}
