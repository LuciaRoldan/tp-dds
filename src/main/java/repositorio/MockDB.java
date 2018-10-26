package repositorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import actuador.Actuador;
import actuador.AireEstadoActuador;
import categoria.CategoriaResidencial;
import dispositivo.DispositivoFactory;
import dispositivo.estados.Encendido;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import dispositivosConcretos.Lampara;
import dispositivosConcretos.Lavarropas;
import dispositivosConcretos.Microondas;
import dispositivosConcretos.PC;
import dispositivosConcretos.Plancha;
import dispositivosConcretos.Televisor;
import dispositivosConcretos.Ventilador;
import mock.ApagadoMock;
import mock.EncendidoMock;
import regla.Condicion;
import regla.CondicionTemperaturaAlta;
import regla.CondicionVentanaAbierta;
import regla.Regla;
import sensor.Sensor;
import usuario.Administrador;
import usuario.Cliente;
import usuario.TipoDocumento;

public class MockDB {
	
	public void inicializarDB() {
		RepositorioDeUsuarios repo = new RepositorioDeUsuarios();
		
		/////////////// Persisto un cliente con un dispositivo con estados //////////////////////////////
		
		Cliente cliente = new Cliente("Maximo Cozzetti", "Calle falsa 123", LocalDate.of(2001, 01, 01), "ro", "xd", TipoDocumento.DNI ,  007, 4545-4545, CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
		
		Televisor tv;
		Lampara lampara;
		Lavarropas lavarropas;
		PC pc;
		AireAcondicionado aireAcondicionado;
		Microondas microondas;
		Plancha plancha;
		Ventilador ventilador;
		
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("aire");
		AireAcondicionado aire = factory.crearAireAcondicionado(2200);
        EncendidoMock encendido1 = new EncendidoMock(LocalDateTime.now().minus(25, ChronoUnit.DAYS), LocalDateTime.now().minus(20, ChronoUnit.DAYS));
        ApagadoMock apagado1 = new ApagadoMock(LocalDateTime.now().minus(20, ChronoUnit.DAYS), LocalDateTime.now().minus(15, ChronoUnit.DAYS));
        EncendidoMock encendido2 = new EncendidoMock(LocalDateTime.now().minus(15, ChronoUnit.DAYS), LocalDateTime.now().minus(10, ChronoUnit.DAYS));
        ApagadoMock apagado2 = new ApagadoMock(LocalDateTime.now().minus(10, ChronoUnit.DAYS), LocalDateTime.now().minus(5, ChronoUnit.DAYS));
		Encendido encendido3 = new Encendido();
		
		factory.setNombre("tv");
		tv = factory.crearTelevisorLED(40);
		tv.setEstado(encendido1);

		factory.setNombre("lampara");
		lampara = factory.crearLamparaComun(11);
		lampara.setEstado(encendido2);

		factory.setNombre("lavarropas");
		factory.setHorasUsoMensuales(30);
		lavarropas = factory.crearLavarropasSemiAutomatico(false, 5);

		factory.setNombre("pc");
		factory.setHorasUsoMensuales(20);
		pc = factory.crearPC();

		factory.setNombre("aire");
		aireAcondicionado = factory.crearAireAcondicionado(2200);
		aireAcondicionado.setEstado(encendido3);

		factory.setNombre("microondas");
		factory.setHorasUsoMensuales(5);
		microondas = factory.crearMicroondas();

		factory.setNombre("plancha");
		factory.setHorasUsoMensuales(15);
		plancha = factory.crearPlancha();

		factory.setNombre("ventilador");
		ventilador = factory.crearVentiladorDeTecho();
		ventilador.setEstado(encendido1);


		aire.agregarEstado(encendido1);
		aire.agregarEstado(apagado1);
		aire.agregarEstado(encendido2);
		aire.agregarEstado(apagado2);
		aire.agregarEstado(encendido3);
		
		List<DispositivoConcreto> disp = new ArrayList<DispositivoConcreto>();
	    disp.add(aire);
	    disp.add(tv);
	    disp.add(lampara);
	    disp.add(lavarropas);
	    disp.add(pc);
	    disp.add(aireAcondicionado);
	    disp.add(microondas);
	    disp.add(plancha);
	    disp.add(ventilador);
	    cliente.setDispositivos((ArrayList<DispositivoConcreto>) disp);
	    
	    
		Sensor sensorTemperatura = new Sensor();
		Sensor sensorVentana = new Sensor();
		CondicionTemperaturaAlta hacen30Grados = new CondicionTemperaturaAlta(sensorTemperatura, 30);
		CondicionVentanaAbierta estaCerrada = new CondicionVentanaAbierta(sensorVentana, false);
		AireEstadoActuador actuadorAire = new AireEstadoActuador(aire,true);
		
		ArrayList<Actuador> actuadores = new ArrayList <Actuador>();
		ArrayList<Condicion> condiciones = new ArrayList <Condicion>();
		actuadores.add(actuadorAire);
		condiciones.add(hacen30Grados);
		condiciones.add(estaCerrada);
		
		new Regla(actuadores, condiciones);

		sensorVentana.cambiarMedicion(0);
		sensorVentana.agregarUnidad("% apertura");
		sensorVentana.agregarDescripcion("Medicion de la ventana");

		sensorTemperatura.cambiarMedicion(35);
		sensorTemperatura.agregarUnidad("°C");
		sensorTemperatura.agregarDescripcion("Medicion de la temperatura");
		
		cliente.agregarSensor(sensorVentana);
		cliente.agregarSensor(sensorTemperatura);
	    repo.agregarUsuario(cliente);
	    
		//////////////// Persisto un administrador ///////////////////////////////
	    
	    Administrador administrador = new Administrador("Juan Perez", "Calle Falsa 123", LocalDate.now().minusMonths(1), "hola", "1997", (float) 0 ,(float) 0);
	    repo.agregarUsuario(administrador);
	
	}
}
