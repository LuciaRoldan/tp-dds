package dispositivos;

import java.time.LocalDateTime;

public class Apagado implements Estado {

	private LocalDateTime inicio = LocalDateTime.now(); //esta bien? Se registra
	//cuando instancio la clase ?? O hay que ponerlo en el constructor??
	private LocalDateTime fin;
	
	public Apagado() {
		
	}
	
	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public boolean estaApagado() {
		return true;
	}

	@Override
	public void apagate(DispositivoInteligente dispositivo) {		
	}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}

	@Override
	public void activarAhorroDeEnergia(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new AhorroDeEnergia());
	}
	
	@Override
	public Long calcularConsumo(Long kWh) {
		return Long.valueOf(0);
	}

	@Override
	public LocalDateTime getFin() {
		return fin;
	}

	@Override
	public LocalDateTime getInicio() {
		return inicio;
	}
	
	@Override
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin) {
		return this.getInicio().isAfter(inicio) && this.getFin().isBefore(fin);
	}
	
	@Override
	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin) {
		return 		(this.getInicio().isBefore(inicio) && this.getFin().isBefore(fin))
				|| (this.getInicio().isAfter(inicio) && this.getFin().isAfter(fin))
				|| (this.getInicio().isBefore(inicio) && this.getFin().isAfter(fin));
	}

	@Override
	public Long calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		return Long.valueOf(0);
	}

}
