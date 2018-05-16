package dispositivos;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DispositivoBuilder {

	private String nombre;
	private Long kWh;
	private TipoDeDispositivo tipoDeDispositivo;
	private int horasDeUsoPorDia;

	
	public DispositivoBuilder(String nombre, Long KWh, TipoDeDispositivo tipoDeDispositivo,
								int horasDeUsoPorDia) {
		this.nombre = nombre;
		this.kWh = KWh;
		this.tipoDeDispositivo = tipoDeDispositivo;
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

	public Dispositivo construir() {

		Dispositivo dispositivo;

		if (this.tipoDeDispositivo.esInteligente()) {
			DispositivoInteligente claseInteligente = new DispositivoInteligente();
			claseInteligente.setEstado(new Apagado());
			dispositivo = new Dispositivo(this.nombre, this.kWh, claseInteligente);
		} else {
			DispositivoEstandar claseEstandar = new DispositivoEstandar();
			claseEstandar.setHorasDeUsoPorDia(horasDeUsoPorDia);
			dispositivo = new Dispositivo(this.nombre, this.kWh, claseEstandar);
		}

		return dispositivo;

	}
	
	@JsonCreator
	public DispositivoBuilder() {}


}
