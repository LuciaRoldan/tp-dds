package db;

import categoria.CategoriaResidencial;
import dispositivo.DispositivoFactory;
import dispositivosConcretos.AireAcondicionado;
import dispositivosConcretos.DispositivoConcreto;
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
