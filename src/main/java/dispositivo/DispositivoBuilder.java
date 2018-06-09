package dispositivo;

import module.module;
import com.fasterxml.jackson.annotation.JsonCreator;

public class DispositivoBuilder {

	private String nombre;
	private Long kWh;
	private DispositivoInteligente dispositivo;
	private int horasDeUsoPorDia = -1;

	
	public DispositivoBuilder(String nombre, Long KWh, DispositivoInteligente tipoDeDispositivo,
								int horasDeUsoPorDia) {
		this.nombre = nombre;
		this.kWh = KWh;
		this.horasDeUsoPorDia = horasDeUsoPorDia;;
	}

	public void setConsumoHora(int horas){
		this.horasDeUsoPorDia = horas;
	}

	public DispositivoInteligente construir() {

		if(horasDeUsoPorDia > 0){
			this.dispositivo = new module(new  DispositivoEstandar(this.kWh,this.nombre,this.horasDeUsoPorDia));
		}

		return this.dispositivo;

	}
	
	@JsonCreator
	public DispositivoBuilder() {}


}
