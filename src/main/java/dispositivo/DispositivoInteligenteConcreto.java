package dispositivo;

import estadoDispositivo.EstadoDispositivo;
import exceptionDispositivo.DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DispositivoInteligenteConcreto implements DispositivoInteligente {

	private EstadoDispositivo estado;
	private String nombre;
	private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();

	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligenteConcreto() {}
	
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

	///////////////////// METODOS /////////////////////

	public Long consumoMensual(Long kWh) {
		return calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now(), kWh);
	}
	

	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
		ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
		
		estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
		.forEach(estado -> estadosCompletosPeriodo.add(estado));
		estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
		.forEach(estado -> estadosBordePeriodo.add(estado));
		
		return estadosCompletosPeriodo.stream().mapToLong(estado -> estado.calcularConsumo(kWh)).sum() 
		+ estadosBordePeriodo.stream().mapToLong(estado -> estado.calcularConsumoBorder(inicio, fin, kWh)).sum();
	}
	

	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
		return this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now(), kWh);
	}
	

	public boolean esInteligente() {
		return true;
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

	public Long 					getkWh() 						{ throw new DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh(this);				 }
	public String 					getNombre() 				 	{ return nombre;				 }

	//////////////////////////////////// SETTERS ////////////////////////////////////

	public void 					setNombre(String nombre) 	 	{ this.nombre = nombre; 		}
	public void 					setkWh(Long kWh) 			 	{ throw new DispositivoInteligenteInteligenteConcretoNoTieneAtributokWh(this);
	}

}
