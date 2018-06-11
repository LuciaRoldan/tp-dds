package dispositivo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh;

public class DispositivoInteligenteConcreto implements DispositivoInteligente {

	private EstadoDispositivo estado;
	private String name;
	private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();
	private Long kWh;

	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligenteConcreto(String name,EstadoDispositivo estadoInicial,Long kWh) {
		this.name = name;
		this.estado = estadoInicial;
		this.kWh = kWh;
	}
	
	//////////////// SETTERS Y GETTERS ////////////////


	public EstadoDispositivo getEstado() {
		return this.estado;
	}
	public void setEstado(EstadoDispositivo estado) {
		this.estado = estado;
	}
	public void agregarEstado(EstadoDispositivo estado) {
		estadosAnteriores.add(estado);
	}
	public String getName(){return name;}

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
		
		return estadosCompletosPeriodo.stream().mapToLong(estado -> estado.calcularConsumo(kWh)).sum() 
		+ estadosBordePeriodo.stream().mapToLong(estado -> estado.calcularConsumoBorder(inicio, fin, this.kWh)).sum();
	}
	

	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
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

	public void agregarModulo() {}






	///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

	public Long getkWh() {
		return this.kWh;
	}

	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void setName(String name) 	 	{ this.name = name; 		}
	public void 					setkWh(Long kWh) 			 	{ throw new DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh(this);
	}

}
