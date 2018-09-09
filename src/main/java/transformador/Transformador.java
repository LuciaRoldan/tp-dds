package transformador;

import usuario.Cliente;
import zona.Zona;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
public class Transformador {

			
    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    @Transient
    private Zona  zona;
    private Integer zonaId;
    private String nombre;
    @Transient
    private List<Cliente> listaDeClientes = new ArrayList<Cliente>();
    @ElementCollection
    private List<Integer> listaDeClientesId = new ArrayList<Integer>();
    @GeneratedValue
    @Id
    private Integer numeroDeTransformador;

    ///////////////////////////////////GETTERS Y SETTERS ////////////////////////////////////

    public Integer getNumeroDeId(){return this.numeroDeTransformador;}

    public void addCliente(Cliente cliente){
        listaDeClientes.add(cliente);
    }

    public Float getCoordenadaY() {
        return this.coordenadaY;
    }

    public Float getCoordenadaX() {
        return this.coordenadaX;
    }

///////////////////////////////// METODOS ///////////////////////////////////////////////

    public Long energiaSuministrada(){
        return   listaDeClientes.stream().mapToLong(cliente -> cliente.calcularConsumoAhora()).sum();
    }
    
    @JsonCreator
	public Transformador(){}


    public Transformador(List<Cliente> listaDeClientes,String nombre,Zona zona, Float coordenadaX, Float coordenadaY ){
        this.listaDeClientes = listaDeClientes;
        this.nombre = nombre;
        this.zona = zona;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        if (listaDeClientes != null){
            for (Cliente cliente : listaDeClientes) {
                listaDeClientesId.add(cliente.getNumeroDeCliente());
            }
        }
    }

    public Integer getNumeroDeTransformador() {
        return this.numeroDeTransformador;
    }

    public Integer getId() {
        return this.numeroDeTransformador;
    }
}
