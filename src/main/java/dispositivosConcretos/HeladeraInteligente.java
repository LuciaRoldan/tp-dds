package dispositivosConcretos;

import dispositivo.DispositivoInteligenteConcreto;
import dispositivo.estados.EstadoDispositivo;

public class HeladeraInteligente extends DispositivoInteligenteConcreto{
	
	boolean tieneFreezer;
	
	public HeladeraInteligente(String name, EstadoDispositivo estadoInicial, Long kWh,
			double usoMensualMinimo, double usoMensualMaximo, boolean esBajoConsumo, boolean tieneFreezer) {
		super(name, estadoInicial, kWh, usoMensualMinimo, usoMensualMaximo, esBajoConsumo);
		this.tieneFreezer = tieneFreezer;
	}
	
	public boolean tieneFreezer() {
		return this.tieneFreezer;
	}
}
