package transformador;

import usuario.Cliente;
import zona.Zona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
public class Transformador {

			
    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true, name = "numeroDeTransformador")
    public List<Cliente> listaDeClientes = new ArrayList<Cliente>();
    
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    public String getNombre() {
    	return this.nombre;
    }

///////////////////////////////// METODOS ///////////////////////////////////////////////

    public double consumoPromedio(LocalDateTime inicio, LocalDateTime fin) {
        return listaDeClientes.stream().mapToDouble(cliente -> cliente.consumoHogarPeriodo(inicio, fin)).sum();
    }


    public Long energiaSuministrada(){
        return   listaDeClientes.stream().mapToLong(cliente -> cliente.calcularConsumoAhora()).sum();
    }
    
    @JsonCreator
	public Transformador(){}


    public Transformador(List<Cliente> listaDeClientes,String nombre,Zona zona, Float coordenadaX, Float coordenadaY ){
        this.listaDeClientes = listaDeClientes;
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Integer getNumeroDeTransformador() {
        return this.numeroDeTransformador;
    }

    public Integer getId() {
        return this.numeroDeTransformador;
    }
}
