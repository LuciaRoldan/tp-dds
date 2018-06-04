package reglasactsens;

import java.util.List;

public class CondicionVentanaAbierta extends Condicion {
	boolean abierta;
	
	public CondicionVentanaAbierta(List<Regla> reglas, boolean abierta) {
		super(reglas);
		this.abierta = abierta;
	}

	@Override
	public boolean evaluarCumplimiento(Integer medicionPorcentajeAbierta) { //porcentaje de abierta de la ventana
		return medicionPorcentajeAbierta < 99;
	}
	
}
