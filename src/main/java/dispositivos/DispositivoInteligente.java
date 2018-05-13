package dispositivos;

public class DispositivoInteligente extends TipoDeDispositivo {
    
	DispositivoInteligente(){};
	
	@Override
	public Long consumoMensual(){return (long) 0;} //hacer lol
	
	@Override
	public boolean esInteligente() {
		return true;
	}
	
	@Override
    public String getNombre(){return "INTELIGENTE";}
}
