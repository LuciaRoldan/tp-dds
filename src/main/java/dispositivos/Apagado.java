package dispositivos;

public class Apagado implements Estado {

	@Override
	public boolean estaEncendido() {
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
