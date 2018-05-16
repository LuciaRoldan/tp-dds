package dispositivos;

public class DispositivoEstandar extends TipoDeDispositivo {

	private Long kWh;
	private int horasDeUsoPorDia;
	
	public DispositivoEstandar() {}
	
	@Override
	public Long consumoMensual() {
		return kWh * horasDeUsoPorDia * 30;
	}

	@Override
	public boolean esInteligente() {
		return false;
	}	
	///////////// GETTERS/////////////
	public Long getkWh() {
		return kWh;
	}

	public int getHorasDeUsoPorDia() {
		return horasDeUsoPorDia;
	}

	///////////// SETTERS/////////////

	public void setkWh(Long kWh) {
		this.kWh = kWh;
	}

	public void setHorasDeUsoPorDia(int horasDeUsoPorDia) {
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

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

	@Override
	public String getNombre() {
		return "ESTANDAR";
	}

	@Override
	public Estado getEstado() {
		return new Apagado();
	}
}
