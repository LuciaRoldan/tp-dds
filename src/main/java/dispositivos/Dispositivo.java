package dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;

public class Dispositivo {
	private String  		  nombre;
	private Long 			  kWh;
	private Boolean 		  encendido;
    private TipoDeDispositivo tipoDeDispositivo;


    ///////////////////////////////// CONTRUCTORES /////////////////////////////////////////////////////

    public Dispositivo(){}

    public Dispositivo(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo){
		this.inicializar( nombre,  kWh,  encendido,  tipoDeDispositivo);
	}
	// ESTA FUNCION LA USA EL PARSER
    @JsonCreator
	public void inicializar(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo) {
		this.nombre = nombre;
		this.kWh = kWh;
		this.encendido = encendido;
		this.tipoDeDispositivo = tipoDeDispositivo;
	}

	// ESTA FUNCION LA USA EL PARSER
	@JsonProperty("tipoDeDispositivo")
	public void setType(String type) throws IOException {
		this.tipoDeDispositivo = tipoDeDispositivo.fromString(type);
	}

	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public Long 					getkWh() 						{ return kWh;					 }
	public String 					getNombre() 				 	{ return nombre;				 }
	public TipoDeDispositivo		getTipoDeDispositivo()		 	{ return this.tipoDeDispositivo; }
	public Boolean 					isEncendido() 			     	{ return encendido;			  	 }


	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void 					setNombre(String nombre) 	 	{ this.nombre = nombre; 		}
	public void 					setkWh(Long kWh) 			 	{	this.kWh = kWh;				}
	public void 					setEncendido(boolean encendido) { this.encendido = encendido;   }

}


