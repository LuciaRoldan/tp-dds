package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class EstadoDispositivo {
	
	public LocalDateTime inicio;
	public LocalDateTime fin;

	public abstract boolean estaEncendido();

	public abstract boolean estaApagado();

	public abstract void apagate(DispositivoInteligenteInterfaz dispositivo);

	public abstract void encendete(DispositivoInteligenteInterfaz dispositivo);

	public abstract void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivoInteligenteConcreto);
	
	//
	public abstract double consumoTotal(double potencia);

	public abstract double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, double potencia);
	//
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}
		
	public LocalDateTime getFin() {
		return fin;
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

	public boolean incluyeA(LocalDateTime x) {
		return this.inicio.compareTo(x) * x.compareTo(this.fin) >= 0;
	}
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin) {
		if (this.getFin() == null) {
			return false;
		} else {
		return this.incluyeA(inicio) && this.incluyeA(fin);
		}
	}
	
	
	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin) {
		if (this.getFin() == null) {
			return true;
		} else { return
				inicio.isBefore(this.inicio) && this.incluyeA(fin) ||
				fin.isAfter(this.fin) && this.incluyeA(inicio) ||
				inicio.isBefore(this.inicio) && fin.isAfter(this.fin)
				;	
		}
	}
	
	public long tiempoEnHoras() {
		if (this.fin == null){
			return this.inicio.until(LocalDateTime.now(), ChronoUnit.HOURS);
		}else {
			return this.inicio.until(this.fin, ChronoUnit.HOURS);
		}
	}
	
	public long tiempoEnHorasEnIntervalo(LocalDateTime inicio, LocalDateTime fin) {
		if(inicio.isBefore(this.inicio) && this.incluyeA(fin)) {
			return this.inicio.until(fin, ChronoUnit.HOURS);
		}else if(fin.isAfter(this.fin) && this.incluyeA(inicio)) {
			return inicio.until(this.fin,ChronoUnit.HOURS);
		}else if(inicio.isBefore(this.inicio) && fin.isAfter(this.fin)) {
			return this.tiempoEnHoras();
		}else {
			return 0;
		}
	}

}
