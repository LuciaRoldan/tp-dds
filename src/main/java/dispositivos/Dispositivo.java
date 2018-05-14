package dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;

public class Dispositivo {
	private String nombre;
	private Long kWh;
	private Boolean encendido;
	private TipoDeDispositivo tipoDeDispositivo;

	///////////////////////////////// CONTRUCTORES///////////////////////////////// /////////////////////////////////////////////////////


	public Dispositivo() {
	}

	public Dispositivo(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo) {
		this.inicializar(nombre, kWh, encendido, tipoDeDispositivo);
	}

	    
    ///////////////////////////////// METODOS ///////////////////////////////// 
    
    public Long consumoMensual() {
    	return tipoDeDispositivo.consumoMensual();
    }
    public void agregarModulo() {
    	tipoDeDispositivo = new DispositivoInteligente();
    }
    public boolean esInteligente() {
    	return tipoDeDispositivo.esInteligente();
    }
	
	public boolean estaEncendido() {
		return this.getTipoDeDispositivo().estaEncendido();
	}
	
	public boolean estaApagado() {
		return this.getTipoDeDispositivo().estaApagado();
	}
	
	public void encendete() {
		this.getTipoDeDispositivo().encendete();
	}
	
	public void apagate() {
		this.getTipoDeDispositivo().apagate();
	}
	
	public void activarAhorroDeEnergia() {
		this.getTipoDeDispositivo().activarAhorroDeEnergia();
	}
    
	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public Long 					getkWh() 						{ return kWh;					 }
	public String 					getNombre() 				 	{ return nombre;				 }
	public TipoDeDispositivo		getTipoDeDispositivo()		 	{ return this.tipoDeDispositivo; }
	public Boolean 					isEncendido() 			     	{ return encendido;	}


	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void 					setNombre(String nombre) 	 	{ this.nombre = nombre; 		}
	public void 					setkWh(Long kWh) 			 	{	this.kWh = kWh;				}
	public void 					setEncendido(boolean encendido) { this.encendido = encendido;   }
	public void setTipoDeDispositivo(TipoDeDispositivo tipoDeDispositivo) { this.tipoDeDispositivo = tipoDeDispositivo;}


	// ESTA FUNCION LA USA EL PARSER
	@JsonCreator
	public void inicializar(String nombre, Long kWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo) {
		this.nombre = nombre;
		this.kWh = kWh;
		this.encendido = encendido;
		this.tipoDeDispositivo = tipoDeDispositivo;
	}

}
