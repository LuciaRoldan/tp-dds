package dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;

public class Dispositivo {
	private String nombre;
	private Long kWh;
	private Boolean encendido;
    private TipoDeDispositivo tipoDeDispositivo;


    public Dispositivo(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo){
		this.inicializar( nombre,  kWh,  encendido,  tipoDeDispositivo);

	}


    @JsonCreator
	public void inicializar(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo) {
		this.nombre = nombre;
		this.kWh = kWh;
		this.encendido = encendido;
		this.tipoDeDispositivo = tipoDeDispositivo;
	}

	@JsonProperty("tipoDeDispositivo")
	public void setType(String type) throws IOException {
		this.tipoDeDispositivo = tipoDeDispositivo.fromString(type);
	}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) { this.nombre = nombre; }
	public TipoDeDispositivo getTipoDeDispositivo(){ return this.tipoDeDispositivo;}
	public Long getkWh() { return kWh;	}
	public void setkWh(Long kWh) {	this.kWh = kWh;	}
	public Boolean isEncendido() 	{ return encendido; }
	public void setEncendido(boolean encendido) { this.encendido = encendido; }


}


