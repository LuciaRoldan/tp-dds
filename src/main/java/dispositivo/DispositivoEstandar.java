package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.dispositivoEstandar.NoSePuedeCalcularElConsumoException;

@Entity
public class DispositivoEstandar extends DispositivoBase {
	
	private String name;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private double potencia;
	private boolean esBajoConsumo;
	private double horasUsoMensuales;
	

	public DispositivoEstandar(String name, double usoMensualMinimo, double usoMensualMaximo, double horasUsoMensuales){
		this.name = name;
		this.setUsoMensualMinimo(usoMensualMinimo);
		this.setUsoMensualMaximo(usoMensualMaximo);
		this.esBajoConsumo = false;
		this.horasUsoMensuales = horasUsoMensuales;
	}
	

	///////////// GETTERS/////////////

	public String getName() {return this.name;}

	//public Long getkWh(){return this.kWh;}
	
	public double getUsoMensualMaximo() {
		return usoMensualMaximo;
	}
	
	public double getUsoMensualMinimo() {
		return usoMensualMinimo;
	}


	///////////// SETTERS/////////////

	public void setName(String name){this.name = name;}
	
	//public void setkWh(Long kWh) {this.kWh = kWh;}
	
	public void setUsoMensualMaximo(double usoMensualMaximo) {
		this.usoMensualMaximo = usoMensualMaximo;
	}
	
	public void setUsoMensualMinimo(double usoMensualMinimo) {
		this.usoMensualMinimo = usoMensualMinimo;
	}
	
	public void setBajoConsumo(boolean bajoConsumo) {
		this.esBajoConsumo = bajoConsumo;
	}	


/////////////METODOS/////////////

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		long horas = inicio.until(fin, ChronoUnit.HOURS);
		return (horas * consumoPorHora());
	}

	public double calcularConsumoUltimasNHoras(int horas, Long kWh) {
		return horas * consumoPorHora();
	}
	
	public double consumoCorriente() {
		int mesActual = LocalDate.now().getMonthValue();
		int anoActual = LocalDate.now().getYear();
		LocalDateTime fechaInicio = LocalDateTime.of(anoActual, mesActual, 1, 0, 0, 0);
		return this.calcularConsumoPeriodo(fechaInicio, LocalDateTime.now());
	}

	private double consumoPorHora() {
		return horasUsoMensuales / (24 * 30);
	}

	@Override
	public double consumoMensual() {
		return this.horasUsoMensuales; 
	}		

	@Override
	public void activarAhorroDeEnergia() {
	}

	@Override
	public void setEstado(EstadoDispositivo estado) {
	}

	@Override
	public void apagate() {
	}

	@Override
	public void encendete() {
	}

	@Override
	public boolean estaEncendido() { //que tire excepcion
		return false;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public EstadoDispositivo getEstado() {
		return null;
	}

	@Override
	public double calcularConsumoUltimasNHoras(int horas) {
		return 0;
	}

	@Override
	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		return 0;
	}
	
	@Override
	public boolean esInteligente() {return false;}


	@Override
	public void agregarEstado(EstadoDispositivo estado) {}


	@Override
	public double getPotencia() {
		return this.potencia;
	}


	@Override
	public double getHorasDeUsoIdeal() {
		return this.getHorasDeUsoIdeal();
	}


	@Override
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

}
