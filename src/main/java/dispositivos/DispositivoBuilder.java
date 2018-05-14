package dispositivos;

import static java.util.Arrays.asList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DispositivoBuilder {

	private String nombre;
	private Long kWh;
	private Boolean encendido;
	private TipoDeDispositivo tipoDeDispositivo;
	private int horasDeUsoPorDia;

	public DispositivoBuilder() {
	}

	public DispositivoBuilder(String nombre, Long KWh, Boolean encendido, TipoDeDispositivo tipoDeDispositivo, int horasDeUsoPorDia) {
		this.nombre = nombre;
		this.kWh = KWh;
		this.encendido = encendido;
		this.tipoDeDispositivo = tipoDeDispositivo;
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

	public Dispositivo construir() {

		Dispositivo dispositivo;

		if (this.tipoDeDispositivo.esInteligente()) {
			dispositivo = new Dispositivo(this.nombre, this.kWh, this.encendido, new DispositivoInteligente());
		} else {
			dispositivo = new Dispositivo(this.nombre, this.kWh, this.encendido,
					new DispositivoEstandar(horasDeUsoPorDia));
		}

		return dispositivo;

	}

	@JsonCreator
	public static DispositivoBuilder fromString(String dispositivoBuilder) {
		DispositivoBuilder builder = new DispositivoBuilder();
		return builder;
	}

}
