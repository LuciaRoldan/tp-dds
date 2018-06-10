package reglasactsens;

public class CondicionTemperaturaAlta extends Condicion {
	int temperaturaLimite;
	
	public CondicionTemperaturaAlta(int temperaturaLimite) {
		super();
		this.temperaturaLimite = temperaturaLimite;
	}

	@Override
	public boolean evaluarCumplimiento(Integer medicion) {
		return medicion > this.temperaturaLimite;
	}
}
