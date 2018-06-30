package dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public abstract class DispositivoInteligente implements DispositivoInteligenteInterfaz {

	private EstadoDispositivo estado;
	private String name;
	private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();
	private Long kWh;
	private double consumoIdeal;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private boolean esBajoConsumo;
	

	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligente(String name, EstadoDispositivo estadoInicial,
			double usoMensualMinimo, double usoMensualMaximo) {
		this.name = name;
		this.estado = estadoInicial;
		this.usoMensualMinimo = usoMensualMinimo;
		this.usoMensualMaximo = usoMensualMaximo;
		this.setConsumoIdeal(0);
		this.setEsBajoConsumo(esBajoConsumo);
		this.kWh = (long) 0;
		this.esBajoConsumo = false;
	}

	///////////////////// METODOS /////////////////////

	public Long consumoMensual() {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
	}
	

	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
		ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
		
		estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
		.forEach(estado -> estadosCompletosPeriodo.add(estado));
		estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
		.forEach(estado -> estadosBordePeriodo.add(estado));
		
		return (estadosCompletosPeriodo.stream().mapToLong(estado -> estado.calcularConsumo(this.kWh)).sum()
		+ estadosBordePeriodo.stream().mapToLong(estado -> estado.calcularConsumoBorder(inicio, fin, this.kWh)).sum());
	}
	

	public Long calcularConsumoUltimasNHoras(Long horas) {
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

	public Long getkWh() {
		return this.kWh;
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
	
	public void setkWh(Long kWh) 			 {this.kWh = kWh;}
	
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

}


