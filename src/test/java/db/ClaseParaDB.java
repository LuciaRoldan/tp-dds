package db;

import categoria.CategoriaResidencial;
import dispositivosConcretos.DispositivoConcreto;
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

public class ClaseParaDB {

    static List<Cliente> listaDeClientes = new ArrayList<Cliente>();
    static Float coordenadaX = new Float(10);
    static Float coordenadaY = new Float(10);

    public static Cliente getCliente(){
        return new Cliente("Maximo Cozzetti", "Calle falsa 123", LocalDate.of(2001, 01, 01), "Emilio Ravenna",
                "caracterizacion", TipoDocumento.DNI ,  007, 4545-4545,
        CategoriaResidencial.CATEGORIAR5 ,null, (float) 0, (float) 0);
    }

    public static Sensor getSensor(){
        return new Sensor();
    }

    public static Transformador getTransformador(){
        return new Transformador(listaDeClientes,"Transformador 001" , new Zona(),  coordenadaX, coordenadaY );
    }

    public Zona getZona() {
        return new Zona("Comuna 13", Float.valueOf(1), Float.valueOf(coordenadaX), Float.valueOf(coordenadaY), null);
    }    
}