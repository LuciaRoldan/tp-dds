package dispositivo;

import java.time.LocalDateTime;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.NoSePuedeCalcularElConsumoException;
import exceptionDispositivo.NoSePuedeConocerElEstadoDelEstandarException;

public class DispositivoEstandar  {
	
	private Long horasDeUsoPorDia;
	private String name;
	private Long consumoPorHora;


	public DispositivoEstandar(Long consumoPorHora,String name,Long horasDeUsoPorDia){
		this.consumoPorHora = consumoPorHora;
		this. name = name;
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}
	

	public Long consumoMensual() {
		return consumoPorHora * horasDeUsoPorDia * 30;
	}

	///////////// GETTERS/////////////

	public Long getHorasDeUsoPorDia() {
		return this.horasDeUsoPorDia;
	}

	public String getName() {return this.name;}

	public Long getConsumoPorHora(){return this.consumoPorHora;}


	///////////// SETTERS/////////////

	public void setHorasDeUsoPorDia(Long horasDeUsoPorDia) {
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}
	public void setName(String name){this.name = name;}

/////////////METODOS/////////////



	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException(this);
	}

	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException(this);
	}


}
