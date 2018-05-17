package dispositivos;

public class Dispositivo {
	private String nombre;
	private Long kWh;
	private TipoDeDispositivo tipoDeDispositivo;

	///////////////////////////////// CONTRUCTORES///////////////////////////////// /////////////////////////////////////////////////////


	public Dispositivo() {}

	public Dispositivo(String nombre, Long kWh, TipoDeDispositivo tipoDeDispositivo) {
		this.nombre = nombre;
		this.kWh = kWh;
		this.tipoDeDispositivo = tipoDeDispositivo;
	}

	    
    ///////////////////////////////// METODOS ///////////////////////////////// 
    
    public Long consumoMensual() {
    	return tipoDeDispositivo.consumoMensual(kWh);
    }
    public void agregarModulo() {
    	tipoDeDispositivo = new DispositivoInteligente();
    }
    public boolean esInteligente() {
    	return tipoDeDispositivo.esInteligente();
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
	
	public boolean estaEncendido() {
		return tipoDeDispositivo.estaEncendido();
	}
	
	public boolean estaApagado() {
		return tipoDeDispositivo.estaApagado();
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
