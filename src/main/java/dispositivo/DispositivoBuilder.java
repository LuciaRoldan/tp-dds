package dispositivo;

import com.fasterxml.jackson.annotation.JsonCreator;
import estadoDispositivo.Apagado;

public class DispositivoBuilder {

	private String nombre;
	private Long kWh;
	private DispositivoInteligente;
	private int horasDeUsoPorDia;

	
	public DispositivoBuilder(String nombre, Long KWh, DispositivoInteligente tipoDeDispositivo,
								int horasDeUsoPorDia) {
		this.nombre = nombre;
		this.kWh = KWh;
		this.tipoDeDispositivo = tipoDeDispositivo;
		this.horasDeUsoPorDia = horasDeUsoPorDia;;
	}

	public Dispositivo construir() {

		Dispositivo dispositivo;

		if (this.Disposi.esInteligente()) {
			DispositivoInteligenteConcreto claseInteligente = new DispositivoInteligenteConcreto();
			tipoDeDispositivo.setEstado(new Apagado());
			dispositivo = new Dispositivo(this.nombre, this.kWh, tipoDeDispositivo);
		} else {
			DispositivoEstandar claseEstandar = new DispositivoEstandar();
			tipoDeDispositivo.setHorasDeUsoPorDia(horasDeUsoPorDia);
			dispositivo = new Dispositivo(this.nombre, this.kWh, tipoDeDispositivo);
		}

		return dispositivo;

	}
	
	@JsonCreator
	public DispositivoBuilder() {}


}
