package dispositivos;

public class DispositivoInteligente extends TipoDeDispositivo {

	private Estado estado;

<<<<<<< Updated upstream
	////////////////// CONSTRUCTORES ///////////////////
	public DispositivoInteligente(){};
	public DispositivoInteligente(Estado unEstado){
		this.setEstado(unEstado);
	};
	
	
	//////////////// SETTERS Y GETTERS ////////////////
=======
	DispositivoInteligente() {
	};

	@Override
	public Long consumoMensual() {
		return (long) 0;
	} // hacer lol

	@Override
	public boolean esInteligente() {
		return true;
	}

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	
	///////////////////// METODOS /////////////////////
	@Override
	public Long consumoMensual(){return (long) 0;} //hacer lol
	
	@Override
	public boolean esInteligente() {
		return true;
	}
	
	@Override
	public boolean estaEncendido() {
		return this.getEstado().estaPrendido();
	}
	
	@Override
	public boolean estaApagado() {
		return this.getEstado().estaApagado();
	}
	
	@Override
	public void encendete() {
		this.getEstado().encendete(this);
	}
	
	@Override
	public void apagate() {
		this.getEstado().apagate(this);
	}
	
	@Override
=======

	public boolean estaPrendido() {
		return this.getEstado().estaPrendido();
	}

	public boolean estaApagado() {
		return this.getEstado().estaApagado();
	}

	public void encendete() {
		this.getEstado().encendete(this);
	}

	public void apagate() {
		this.getEstado().apagate(this);
	}

>>>>>>> Stashed changes
	public void activarAhorroDeEnergia() {
		this.setEstado(new AhorroDeEnergia());
	}
}
