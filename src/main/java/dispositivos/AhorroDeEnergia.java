package dispositivos;

public class AhorroDeEnergia extends Encendido {

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		dispositivo.setEstado(new Encendido());
	}
}
