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
	public Long consumoMensual(Long kwH){return (long) 0;} //hacer lol
	
	@Override
	public boolean esInteligente() {
		return true;
	}
	
	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public boolean estaApagado() {
		return estado.estaApagado();
	}
	
	public void encendete() {
		estado.encendete(this);
	}
	
	public void apagate() {
		estado.apagate(this);
	}
	
	@Override
	public void activarAhorroDeEnergia() {
		estado = new AhorroDeEnergia();
	}
}
