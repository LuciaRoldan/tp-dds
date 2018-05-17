package dispositivos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DispositivoInteligente extends TipoDeDispositivo {

	private Estado estado;
	private ArrayList<Estado> estadosAnteriores;

	////////////////// CONSTRUCTORES //////////////////
	public DispositivoInteligente() {
	}	
	
	//////////////// SETTERS Y GETTERS ////////////////

	@Override
	public String getNombre() {
		return "INTELIGENTE";
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void agregarEstado(Estado estado) {
		estadosAnteriores.add(estado);
	}

	///////////////////// METODOS /////////////////////
	
	@Override /////// hacer
	public Long consumoMensual(Long kwH) {
		return (long) 0;
	}
	
	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		ArrayList<Estado> estadosCompletosPeriodo = new ArrayList<>();
		ArrayList<Estado> estadosBordePeriodo = new ArrayList<>();
		
		estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
		.forEach(estado -> estadosCompletosPeriodo.add(estado));
		estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
		.forEach(estado -> estadosBordePeriodo.add(estado));
		
		return estadosCompletosPeriodo.stream().mapToLong(estado -> estado.calcularConsumo(kWh)).sum() 
		+ estadosBordePeriodo.stream().mapToLong(estado -> estado.calcularConsumoBorder(inicio, fin, kWh)).sum();
	}
	
	public Long calcularConsumoNHoras(int horas, Long kWh) {
		this.calcularConsumoPeriodo(inicio, LocalDateTime.now(), kWh)
	}
	
	@Override
	public boolean esInteligente() {
		return true;
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
	
	@Override
	public void activarAhorroDeEnergia() {
		estado.activarAhorroDeEnergia(this);
	}
}
