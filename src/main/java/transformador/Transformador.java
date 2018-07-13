package transformador;

import usuario.Cliente;
import zona.Zona;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Transformador {

			
    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    private Zona  zona;
    private String nombre;
    private List<Cliente> listaDeClientes = new ArrayList<Cliente>();

    ///////////////////////////////////GETTERS Y SETTERS ////////////////////////////////////

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
    }

}
