package dispositivos;

public interface Estado {

	public boolean estaPrendido();
	public boolean estaApagado();
	public void apagate(DispositivoInteligente dispositivo);
	public void encendete(DispositivoInteligente dispositivo);
}
