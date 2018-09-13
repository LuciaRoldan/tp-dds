package db;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoFactory;
import dispositivo.estados.Apagado;
import dispositivo.estados.Encendido;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
import mock.ApagadoMock;
import mock.EncendidoMock;
import regla.Condicion;
import regla.CondicionTemperaturaAlta;
import regla.Regla;
import sensor.Sensor;
import transformador.Transformador;
import usuario.Cliente;
import usuario.TipoDocumento;
import usuario.Usuario;
import zona.Zona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import javax.persistence.GenerationType;

import actuador.Actuador;
import actuador.AireEstadoActuador;

public class ClaseParaDB {

    static List<Cliente> listaDeClientes = new ArrayList<Cliente>();
    static Float coordenadaX = new Float(10);
    static Float coordenadaY = new Float(10);
    
    
    public Sensor unSensor = new Sensor();
    public CondicionTemperaturaAlta condicion;
    AireAcondicionado aire;
    AireEstadoActuador actuador;
    
    public static Cliente getCliente(){
        return new Cliente("Maximo Cozzetti", "Calle falsa 123", LocalDate.of(2001, 01, 01), "Emilio Ravenna",
                "caracterizacion", TipoDocumento.DNI ,  007, 4545-4545,
        CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
    }

    public static DispositivoConcreto unDispositivoConEstados() {
		DispositivoFactory factory = new DispositivoFactory();
		factory.setNombre("aire");
		AireAcondicionado aire = factory.crearAireAcondicionado(2200);
        EncendidoMock encendido1 = new EncendidoMock(LocalDateTime.now().minus(25, ChronoUnit.DAYS), LocalDateTime.now().minus(20, ChronoUnit.DAYS));
        ApagadoMock apagado1 = new ApagadoMock(LocalDateTime.now().minus(20, ChronoUnit.DAYS), LocalDateTime.now().minus(15, ChronoUnit.DAYS));
        EncendidoMock encendido2 = new EncendidoMock(LocalDateTime.now().minus(15, ChronoUnit.DAYS), LocalDateTime.now().minus(10, ChronoUnit.DAYS));
        ApagadoMock apagado2 = new ApagadoMock(LocalDateTime.now().minus(10, ChronoUnit.DAYS), LocalDateTime.now().minus(5, ChronoUnit.DAYS));
		Encendido encendido3 = new Encendido();

		aire.agregarEstado(encendido1);
		aire.agregarEstado(apagado1);
		aire.agregarEstado(encendido2);
		aire.agregarEstado(apagado2);
		aire.agregarEstado(encendido3);
		
		return aire;
    }
    
    
    public static Transformador getTransformador(){
        return new Transformador(listaDeClientes,"Transformador 001" , new Zona(),  coordenadaX, coordenadaY );
    }

    public Zona getZona() {
        return new Zona("Comuna 13", Float.valueOf(1), Float.valueOf(coordenadaX), Float.valueOf(coordenadaY), null);
    }
    
    public Sensor getSensor(){
        return unSensor;
    }
    
    public void settearCondicion() {
    	System.out.print("Test2");
    	condicion.setTemperatura(26);
    	System.out.print("Test3");
    	unSensor.agregarCondicion(condicion);
    }
    
    public Condicion getCondicion() {
    	System.out.print("Test1");
    	settearCondicion();
    	System.out.print("TestUltimo");
        
    	return new CondicionTemperaturaAlta(unSensor, 26);
    }
    
    private void settearActuador() {
    	DispositivoFactory factory = new DispositivoFactory();
        factory.setNombre("aire");
        aire = factory.crearAireAcondicionado(2200);
        actuador.setDispositivo(aire);
        actuador.setEncender(true);
    }
    
    public Actuador getActuador() {
      settearActuador();
      return actuador;
    }
    
    public Regla getRegla() {
    	List<Actuador> actuadores = new ArrayList<Actuador>();
    	List<Condicion> condiciones = new ArrayList<Condicion>();
    	actuadores.add(actuador);
    	condiciones.add(condicion);
    	return new Regla(actuadores, condiciones);
    }
   
    
    
}
