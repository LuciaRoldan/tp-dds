package dispositivos;

public interface Estado {

	public boolean estaEncendido();

	public boolean estaApagado();

	public void apagate(DispositivoInteligente dispositivo);

	public void encendete(DispositivoInteligente dispositivo);

}
