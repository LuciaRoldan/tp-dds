package reglasactsens;

import java.util.List;

public class CondicionTemperaturaAlta extends Condicion {
	int temperaturaLimite;
	AireMuyAltoRegla regla = new AireMuyAltoRegla();
	
	public CondicionTemperaturaAlta(int temperaturaLimite) {
		super();
		this.agregarRegla(regla);
		regla.agregarCondicion(this);
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
