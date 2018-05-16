package dispositivos;

public class DispositivoInteligente extends TipoDeDispositivo {

	private Estado estado;

	////////////////// CONSTRUCTORES ///////////////////
	public DispositivoInteligente() {
	}	
	
	//////////////// SETTERS Y GETTERS ////////////////

	@Override
	public String getNombre() {
		return "INTELIGENTE";
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	///////////////////// METODOS /////////////////////
	
	@Override
	public Long consumoMensual(){return (long) 0;} //hacer lol
	
	@Override
	public boolean esInteligente() {
		return true;
	}
	
	@Override
	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	@Override
	public boolean estaApagado() {
		return estado.estaApagado();
	}
	
	@Override
	public void encendete() {
		estado.encendete(this);
	}
	
	@Override
	public void apagate() {
		estado.apagate(this);
	}
	
	@Override
	public void activarAhorroDeEnergia() {
		estado = new AhorroDeEnergia();
	}
}
