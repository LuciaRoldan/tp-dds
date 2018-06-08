package dispositivo;

import estadoDispositivo.EstadoDispositivo;

public class Dispositivo {
	private String nombre;
	private Long kWh;

	///////////////////////////////// CONTRUCTORES///////////////////////////////// /////////////////////////////////////////////////////


	public Dispositivo() {}

	public Dispositivo(String nombre, Long kWh) {
		this.nombre = nombre;
		this.kWh = kWh;
	}

	    
    ///////////////////////////////// METODOS ///////////////////////////////// 
    
    public Long consumoMensual() {
    	return tipoDeDispositivo.consumoMensual(kWh);
    }
    public void agregarModulo() {
    	tipoDeDispositivo = new DispositivoInteligenteConcreto();
    }
    public boolean esInteligente() {
    	return tipoDeDispositivo.esInteligente();
    }
	
	public void encendete() {
		tipoDeDispositivo.encendete();
	}
	
	public void apagate() {
		tipoDeDispositivo.apagate();
	}
	
	public void activarAhorroDeEnergia() {
		tipoDeDispositivo.activarAhorroDeEnergia();
	}
	
	public boolean estaEncendido() {
		return tipoDeDispositivo.estaEncendido();
	}
	
	public boolean estaApagado() {
		return tipoDeDispositivo.estaApagado();
	}
	
	public EstadoDispositivo getEstado() {
		return tipoDeDispositivo.getEstado();
	}
    
	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public Long 					getkWh() 						{ return kWh;					 }
	public String 					getNombre() 				 	{ return nombre;				 }
	public TipoDeDispositivo		getTipoDeDispositivo()		 	{ return this.tipoDeDispositivo; }

	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void 					setNombre(String nombre) 	 	{ this.nombre = nombre; 		}
	public void 					setkWh(Long kWh) 			 	{	this.kWh = kWh;				}
	public void setTipoDeDispositivo(TipoDeDispositivo tipoDeDispositivo) { this.tipoDeDispositivo = tipoDeDispositivo;}


}
