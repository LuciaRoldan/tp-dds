package dispositivo;

import java.time.LocalDateTime;

import exceptionDispositivo.dispositivoEstandar.NoSePuedeCalcularElConsumoException;

public class DispositivoEstandar {
	
	private String name;
	private Long consumoPorHora;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	

	public DispositivoEstandar(Long consumoPorHora,String name, double usoMensualMinimo, double usoMensualMaximo){
		this.consumoPorHora = consumoPorHora;
		this. name = name;
		this.setUsoMensualMinimo(usoMensualMinimo);
		this.setUsoMensualMaximo(usoMensualMaximo);
	}
	

	///////////// GETTERS/////////////

	public String getName() {return this.name;}

	public Long getConsumoPorHora(){return this.consumoPorHora;}
	
	public double getUsoMensualMaximo() {
		return usoMensualMaximo;
	}
	
	public double getUsoMensualMinimo() {
		return usoMensualMinimo;
	}


	///////////// SETTERS/////////////

	public void setName(String name){this.name = name;}
	
	public void setConsumoPorHora(Long consumo) {this.consumoPorHora = consumo;}
	
	public void setUsoMensualMaximo(double usoMensualMaximo) {
		this.usoMensualMaximo = usoMensualMaximo;
	}
	
	public void setUsoMensualMinimo(double usoMensualMinimo) {
		this.usoMensualMinimo = usoMensualMinimo;
	}


/////////////METODOS/////////////



	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException(this);
	}

	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException(this);
	}



}
