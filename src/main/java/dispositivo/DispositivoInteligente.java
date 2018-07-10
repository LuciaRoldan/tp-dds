package dispositivo;

import java.time.LocalDateTime;
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
		this.setConsumoIdeal(0);
		this.setEsBajoConsumo(esBajoConsumo);
		this.esBajoConsumo = false;
	}

	///////////////////// METODOS /////////////////////

	public double consumoMensual() {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
	}
	

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
		ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
		
		estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
		.forEach(estado -> estadosCompletosPeriodo.add(estado));
		estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
		.forEach(estado -> estadosBordePeriodo.add(estado));
		
		return (estadosCompletosPeriodo.stream().mapToDouble(estado -> estado.calcularConsumo(this.potencia)).sum()
		+ estadosBordePeriodo.stream().mapToDouble(estado -> estado.calcularConsumoBorder(inicio, fin, this.potencia)).sum());
	}
	

	public double calcularConsumoUltimasNHoras(int horas) {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now());
	}
	

	public boolean estaEncendido() {
		return estado.estaEncendido();
	}
	
	public boolean estaApagado() {return estado.estaApagado();
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
		this.estado = estado;
	}
	public void agregarEstado(EstadoDispositivo estado) {
		estadosAnteriores.add(estado);
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public boolean esInteligente() {
		return true;
	}

	@Override
	public double getHorasDeUsoIdeal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBajoConsumo(boolean bajoConsumo) {
		// TODO Auto-generated method stub
		
	}

}


