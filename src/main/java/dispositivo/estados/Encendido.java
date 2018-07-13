package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Encendido implements EstadoDispositivo {
	
	public LocalDateTime inicio;
	public LocalDateTime fin = LocalDateTime.of(2050, 9, 9, 00, 00);
	
	public Encendido() {
		inicio = LocalDateTime.now();
	}
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
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
	public void apagate(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Apagado());
	}

	@Override
	public void encendete(DispositivoInteligenteInterfaz dispositivo) {
	}
	
	@Override
	public void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new AhorroDeEnergia());
	}
	
	@Override
	public double calcularConsumo(double potencia) {
		return inicio.until(fin, ChronoUnit.HOURS) * potencia;
	}
	
	@Override
	public double calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, double potencia) {
		return this.maximo(inicio, this.getInicio())
				.until(this.minimo(fin, this.getFin()), ChronoUnit.HOURS) * potencia;
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
