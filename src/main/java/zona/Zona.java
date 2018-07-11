package zona;

import com.fasterxml.jackson.annotation.JsonCreator;
import transformador.Transformador;
import usuario.Cliente;

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class Zona {


    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    private Float radio;
    private String nombre;
    private List<Transformador> listaDeTransformadores = new ArrayList<Transformador>();

    ///////////////////////////////// GETTERS Y SETTERS /////////////////////////////////////


    public void addTransformador(Transformador transformador){
        listaDeTransformadores.add(transformador);
    }

    public Float getCoordenadaY() {
        return this.coordenadaY;
    }

    public Float getCoordenadaX() {
        return this.coordenadaX;
    }

    ///////////////////////////////// METODOS ///////////////////////////////////////////////
    @JsonCreator
    public Zona() {}

    public Zona(String nombre, Float radio, Float coordenadaX, Float coordenadaY, List<Transformador> listaDeTransformadores) {
        this.nombre = nombre;
        this.radio = radio;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.listaDeTransformadores = listaDeTransformadores;
    }
    
    public Long energiaSuministrada(){
        return   listaDeTransformadores.stream().mapToLong(transformador -> transformador.energiaSuministrada()).sum();
    }

}
