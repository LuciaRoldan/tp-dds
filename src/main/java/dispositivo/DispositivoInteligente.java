package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public class DispositivoInteligente implements DispositivoInteligenteInterfaz {

	private EstadoDispositivo estado;
	private String name;
	private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();
	private double potencia;
	private double consumoIdeal;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private double HorasDeUsoIdeal;
	private boolean esBajoConsumo;

	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligente(String name, EstadoDispositivo estadoInicial,
			double usoMensualMinimo, double usoMensualMaximo) {
		this.name = name;
		this.estado = estadoInicial;
		this.estadosAnteriores.add(estadoInicial);
		this.usoMensualMinimo = usoMensualMinimo;
		this.usoMensualMaximo = usoMensualMaximo;
		this.consumoIdeal = 0;
		this.esBajoConsumo = false;
	}

	///////////////////// METODOS /////////////////////

	public double consumoMensual() {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minus(30, ChronoUnit.DAYS), LocalDateTime.now());
	}
	

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		
		double consumoViejo = this.estadosAnteriores
				.stream()
				.mapToDouble(estado -> estado.calcularConsumoPeriodo(inicio, fin, this.potencia) )
				.sum();
		double consumoReciente = this.estado.calcularConsumoPeriodo(inicio, fin, this.potencia);
		
		return consumoViejo + consumoReciente;
	}
	

	public double calcularConsumoUltimasNHoras(int horas) {
		double consumo = this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now());
		return consumo;
	}
	

	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public boolean estaApagado() {
		return estado.estaApagado();
	}
	
	public void encendete() {
		estado.encendete(this);
	}
	
	public void apagate() {
		estado.apagate(this);
	}

	public void activarAhorroDeEnergia() {
		estado.activarAhorroDeEnergia(this);
	}


	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public double getPotencia() {
		return this.potencia;
	}
	public double getConsumoIdeal() {
		return consumoIdeal;
	}
	
	public boolean getEsBajoConsumo() {
		return esBajoConsumo;
	}
	
	public EstadoDispositivo getEstado() {
		return this.estado;
	}
	
	public double getUsoMensualMinimo() {
		return this.usoMensualMinimo;
	}
	
	public double getUsoMensualMaximo() {
		return this.usoMensualMaximo;
	}

	

	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void setName(String name) 	 	{ this.name = name; 		}
	
	public void setPotencia(double potencia) 			 {this.potencia = potencia;}
	
	public void setConsumoIdeal(double consumoIdeal) {this.consumoIdeal = consumoIdeal;}
	
	public void setEsBajoConsumo(boolean esBajoConsumo) {
		this.esBajoConsumo = esBajoConsumo;
	}
	
	public void setUsoMensualMinimo(double consumo) {
		this.usoMensualMinimo = consumo;
	}
	
	public void setUsoMensualMaximo(double consumo) {
		this.usoMensualMaximo = consumo;
	}
	
	public void setEstado(EstadoDispositivo estado) {
		this.agregarEstadoAnterior(this.estado);
		this.estado = estado;
		this.agregarEstado(estado);
	}
	public void agregarEstadoAnterior(EstadoDispositivo estado) {
		estadosAnteriores.add(estado);
	}
	
	public String getName(){
		return this.name;
	}
	
	public double consumoCorriente() {
		int mesActual = LocalDate.now().getMonthValue();
		int anoActual = LocalDate.now().getYear();
		LocalDateTime fechaInicio = LocalDateTime.of(anoActual, mesActual, 1, 0, 0, 0);
		return this.calcularConsumoPeriodo(fechaInicio, LocalDateTime.now());		
	}

	@Override
	public boolean esInteligente() {
		return true;
	}

	@Override
	public double getHorasDeUsoIdeal() {
		// TODO Auto-generated method stub
		return consumoIdeal;
	}

	@Override
	public void setBajoConsumo(boolean bajoConsumo) {
		// TODO Auto-generated method stub
		this.esBajoConsumo = bajoConsumo;
	}

	@Override
	public void agregarEstado(EstadoDispositivo estado) {
		// TODO Auto-generated method stub
		
	}

}


