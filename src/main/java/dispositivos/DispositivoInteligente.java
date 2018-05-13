package dispositivos;

public class DispositivoInteligente extends TipoDeDispositivo {
    
	private Estado estado;

	DispositivoInteligente(){};
	
	@Override
	public Long consumoMensual(){return (long) 0;} //hacer lol
	
	@Override
	public boolean esInteligente() {
		return true;
	}
	
	@Override
    public String getNombre(){return "INTELIGENTE";}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
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
}
