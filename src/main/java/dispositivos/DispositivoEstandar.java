package dispositivos;

public class DispositivoEstandar extends TipoDeDispositivo {

	private Long kWh;
	private int horasDeUsoPorDia;
	
	
	@Override
	public Long consumoMensual() {
		return kWh * horasDeUsoPorDia * 30;
	}

	@Override
	public boolean esInteligente() {
		return false;
<<<<<<< Updated upstream
	}	
	
	/////////////GETTERS/////////////
    public Long getkWh() {
=======
	}

	///////////// GETTERS/////////////
	public Long getkWh() {
>>>>>>> Stashed changes
		return kWh;
	}

	public int getHorasDeUsoPorDia() {
		return horasDeUsoPorDia;
	}
<<<<<<< Updated upstream
	
	@Override
    public String getNombre(){return "ESTANDAR";}
	
	/////////////SETTERS/////////////
=======

	///////////// SETTERS/////////////
>>>>>>> Stashed changes
	public void setkWh(Long kWh) {
		this.kWh = kWh;
	}

	public void setHorasDeUsoPorDia(int horasDeUsoPorDia) {
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

<<<<<<< Updated upstream
/////////////METODOS/////////////
	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public void encendete() {}

	@Override
	public void apagate() {}

	@Override
	public void activarAhorroDeEnergia() {}
=======
	@Override
	public String getNombre() {
		return "ESTANDAR";
	}
>>>>>>> Stashed changes

	@Override
	public Estado getEstado() {
		return new Apagado();
	}
}
