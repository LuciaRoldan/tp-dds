package reglasactsens;


public class CondicionVentanaAbierta extends Condicion {
	boolean abierta; //dice si quiero que la ventana este abierta o cerrada. true = abierta, false = cerrada
	
	public CondicionVentanaAbierta(boolean abierta) {
		this.abierta = abierta;
	}

	@Override
	public boolean evaluarCumplimiento(Integer medicionPorcentajeAbierta) { //porcentaje de abierta de la ventana lol
		return medicionPorcentajeAbierta < 99;
	}
	
}
