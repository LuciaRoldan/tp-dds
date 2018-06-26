package zona;

import transformador.Transformador;
import usuario.Cliente;
import java.util.ArrayList;
import java.util.List;

public class Zona {


    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    private Float radio;
    private String nombre;
    private List<Transformador> listaDeTransformadores = new ArrayList<Transformador>();


    ///////////////////////////////// METODOS ///////////////////////////////////////////////
    public Long energiaSuministrada(){
        return   listaDeTransformadores.stream().mapToLong(transformador -> transformador.energiaSuministrada()).sum();
    }

}
