package zona;

import com.fasterxml.jackson.annotation.JsonCreator;
import transformador.Transformador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zona {


    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
	private Float radio;
    private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = true, name = "numeroDeZona")
    private List<Transformador> listaDeTransformadores = new ArrayList<Transformador>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numeroDeZona;

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
    
    public Float getRadio() {
		return radio;
	}

	public void setRadio(Float radio) {
		this.radio = radio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
        return   this.listaDeTransformadores.stream().mapToLong(transformador -> transformador.energiaSuministrada()).sum();
    }


    public Integer getNumeroDeZona() {
        return this.numeroDeZona;
    }
}
