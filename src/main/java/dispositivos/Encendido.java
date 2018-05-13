package dispositivos;

public class Encendido implements Estado{

	@Override
	public boolean estaPrendido() {
		return true;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public void apagate(DispositivoInteligente dispositivo) {
		dispositivo.setEstado(new Apagado());
	}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
	}

}
