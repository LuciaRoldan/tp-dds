package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import java.time.LocalDateTime;

public class Apagado implements EstadoDispositivo {

	private LocalDateTime inicio;
	private LocalDateTime fin;
	
	public Apagado() {
		inicio = LocalDateTime.now();
	}
	
	protected void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	protected void setFin(LocalDateTime fin) {
		this.fin = fin;
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
	public void apagate(DispositivoInteligenteInterfaz dispositivo) {
	}

	@Override
	public void encendete(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}

	@Override
	public void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivo) {
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
