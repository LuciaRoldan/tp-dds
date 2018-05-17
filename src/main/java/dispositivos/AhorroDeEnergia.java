package dispositivos;

public class AhorroDeEnergia extends Encendido {
	
	public AhorroDeEnergia(){}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		dispositivo.setEstado(new Encendido());
	}
}
