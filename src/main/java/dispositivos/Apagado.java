package dispositivos;

public class Apagado implements Estado{

	@Override
	public boolean estaPrendido() {
		return false;
	}

	@Override
	public boolean estaApagado() {
		return true;
	}

	@Override
	public void apagate(DispositivoInteligente dispositivo) {		
	}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		dispositivo.setEstado(new Encendido());
	}

}
