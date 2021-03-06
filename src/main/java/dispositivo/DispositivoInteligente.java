package dispositivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import dispositivo.estados.EstadoDispositivo;

@Entity
public class DispositivoInteligente extends DispositivoInteligenteAbstracto {
	
	private String name;
	private double potencia;
	private double consumoIdeal;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private boolean esBajoConsumoBoolean;
	private String esBajoConsumo;


	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "numeroDeDispositivoBase", nullable = true)

	private List<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();


	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligente(String name, EstadoDispositivo estadoInicial,
			double usoMensualMinimo, double usoMensualMaximo) {
		this.name = name;		
		this.usoMensualMinimo = usoMensualMinimo;
		this.usoMensualMaximo = usoMensualMaximo;
		this.consumoIdeal = 0;
		this.esBajoConsumoBoolean = false;
		this.setEstado(estadoInicial);
		}
//ACA ARREGLE EL MERGE Y SOLO DEJE QUE EL esBajoConsumoBoolean SEA FALSE POR DEFAULT NO COMPLETE EL esBajoConsumo POR 
	//QUE NO LO NECESITA

	///////////////////// METODOS /////////////////////

	public double consumoMensual() {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minusDays(30), LocalDateTime.now());
	}
	

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		
		double resultado = this.estadosAnteriores
				.stream()
				.mapToDouble(estado -> estado.calcularConsumoPeriodo(inicio, fin, this.potencia) )
				.sum();

		return resultado ;
	}
	

	public double calcularConsumoUltimasNHoras(int horas) {
		double consumo = this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now());
		return consumo;
	}
	
	public double consumoPromedioPorHora(LocalDateTime inicio, LocalDateTime fin) {
		double cantidadHoras = inicio.until(fin, ChronoUnit.HOURS);
		return this.calcularConsumoPeriodo(inicio, fin) / cantidadHoras;
	}
	

	public boolean estaEncendido() {
		return this.getEstado().estaEncendido();
	}
	
	public boolean estaApagado() {
		return this.getEstado().estaApagado();
	}
	
	public void encendete() {
		this.getEstado().encendete(this);
	}
	
	public void apagate() {
		this.getEstado().apagate(this);
	}
	

	public void activarAhorroDeEnergia() {
		this.getEstado().activarAhorroDeEnergia(this);
	}


	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public double getPotencia() {
		return this.potencia;
	}
	public double getConsumoIdeal() {
		return consumoIdeal;
	}

	
	public EstadoDispositivo getEstado() {
		return this.estadosAnteriores.get(this.estadosAnteriores.size()-1);
	}

	public String getEstadoString() { 
		if(this.estaEncendido()) {
			return "Encendido";}
		else {
			if(this.estaApagado()) {
				return "Apagado";
			}else {
				return "Ahorro de energ�a";
			}
		}
	}
	
	public double getUsoMensualMinimo() {
		return this.usoMensualMinimo;
	}
	
	public double getUsoMensualMaximo() {
		return this.usoMensualMaximo;
	}

	@Override
	public List<EstadoDispositivo> getEstadosAnteriores() {
		return this.estadosAnteriores;
	}

	

	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void setName(String name) 	 	{ this.name = name; 		}
	
	public void setPotencia(double potencia) 			 {this.potencia = potencia;}
	
	public void setConsumoIdeal(double consumoIdeal) {this.consumoIdeal = consumoIdeal;}
	
	public void setEsBajoConsumoBoolean(boolean esBajoConsumoBoolean) {
		this.esBajoConsumoBoolean = esBajoConsumoBoolean;
	}
	
	public void setUsoMensualMinimo(double consumo) {
		this.usoMensualMinimo = consumo;
	}
	
	public void setUsoMensualMaximo(double consumo) {
		this.usoMensualMaximo = consumo;
	}
	
	public void setEstado(EstadoDispositivo estado) {
		this.estadosAnteriores.add(estado);
	}
	
	public String getName(){
		return this.name;
	}

	public String getEsBajoConsumoBoolean(){
		String estring = "error";
		if(esBajoConsumoBoolean){
			estring = "SI";
		}else{
			estring = "NO";
		}

		return estring;
	}
	
	
	public double consumoCorriente() {
		int mesActual = LocalDate.now().getMonthValue();
		int anoActual = LocalDate.now().getYear();
		LocalDateTime fechaInicio = LocalDateTime.of(anoActual, mesActual, 1, 0, 0, 0);
		return this.calcularConsumoPeriodo(fechaInicio, LocalDateTime.now());		
	}
	
	public double consumoCorrienteMock() {
		int mesActual = LocalDate.now().getMonthValue();
		int anoActual = LocalDate.now().getYear();
		LocalDateTime fechaInicio = LocalDateTime.of(anoActual, mesActual - 1, 1, 0, 0, 0);
		return this.calcularConsumoPeriodo(fechaInicio, LocalDateTime.of(anoActual, mesActual - 1, 30, 0, 0, 0));		
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
		this.esBajoConsumoBoolean = bajoConsumo;
	}


}


