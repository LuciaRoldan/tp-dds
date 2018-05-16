package dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DispositivoBuilder {

	private String nombre;
	private Long kWh;
	private TipoDeDispositivo tipoDeDispositivo;
	private int horasDeUsoPorDia;

	
	public DispositivoBuilder(String nombre, Long KWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo,
			int horasDeUsoPorDia) {
		this.nombre = nombre;
		this.kWh = KWh;
		this.tipoDeDispositivo = tipoDeDispositivo;
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

	public Dispositivo construir() {

		Dispositivo dispositivo;

		if (this.tipoDeDispositivo.esInteligente()) {
			dispositivo = new Dispositivo(this.nombre, this.kWh, new DispositivoInteligente());
		} else {
			dispositivo = new Dispositivo(this.nombre, this.kWh, new DispositivoEstandar(horasDeUsoPorDia));
		}

		return dispositivo;

	}
	
	@JsonCreator
	public DispositivoBuilder() {}


}
