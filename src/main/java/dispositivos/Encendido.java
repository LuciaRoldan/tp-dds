package dispositivos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Encendido implements Estado {
	
	public LocalDateTime inicio = LocalDateTime.now();
	public LocalDateTime fin;
	
	public Encendido() {
		
	}
	
	@Override
	public boolean estaEncendido() {
		return true;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public void apagate(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Apagado());
	}

	@Override
	public void encendete(DispositivoInteligente dispositivo) {
	}
	
	@Override
	public void activarAhorroDeEnergia(DispositivoInteligente dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new AhorroDeEnergia());
	}
	
	@Override
	public Long calcularConsumo(Long kWh) {
		return inicio.until(fin, ChronoUnit.HOURS) * kWh;
	}
	
	@Override
	public Long calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		return this.maximo(inicio, this.getInicio())
				.until(this.minimo(fin, this.getFin()), ChronoUnit.HOURS) * kWh;
	}

	public LocalDateTime minimo(LocalDateTime fechaMin, LocalDateTime fechaMax) {
		if (fechaMin.isBefore(fechaMax)) {
			return fechaMin;
		} else {
			return fechaMax;
		}
	}
	
	public LocalDateTime maximo(LocalDateTime fechaMin, LocalDateTime fechaMax) {
		if (fechaMin.isAfter(fechaMax)) {
			return fechaMin;
		} else {
			return fechaMax;
		}
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

}
