package reglasactsens;

import java.util.List;

public class CondicionTemperaturaAlta extends Condicion {
	int temperaturaLimite;
	
	public CondicionTemperaturaAlta(List<Regla> reglas, int temperaturaLimite) {
		super(reglas);
		this.temperaturaLimite = temperaturaLimite;
	}

	@Override
	public boolean evaluarCumplimiento(Integer medicion) {
		return medicion > this.temperaturaLimite;
	}

	@Override
	public void notificarMedicion(Integer medicion) {
		boolean nuevoCumplimiento = this.evaluarCumplimiento(medicion);
		if (nuevoCumplimiento != this.seCumple) {
			seCumple = nuevoCumplimiento;
			this.notificarCambioCumplimiento();
		}
	}
	
	
}
