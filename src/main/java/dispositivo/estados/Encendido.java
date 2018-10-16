package dispositivo.estados;


import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteAbstracto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Encendido extends EstadoDispositivo {
	
	public LocalDateTime inicio;
	public LocalDateTime fin;
	
	public Encendido() {
		inicio = LocalDateTime.now();
	}
	
	public boolean estaEncendido() {
		return true;
	}

	public boolean estaApagado() {
		return false;
	}

	public void apagate(DispositivoInteligenteAbstracto dispositivo) {
		this.fin = LocalDateTime.now();
		dispositivo.setEstado(new Apagado());
	}

	public void encendete(DispositivoInteligenteAbstracto dispositivo) {
	}
	
	public void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivo) {
		fin = LocalDateTime.now();
		dispositivo.setEstado(new AhorroDeEnergia());
	}
	
	
	public double consumoTotal(double potencia) {
		return (double) this.tiempoEnHoras() * potencia;
	}

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, double potencia) {
		return (double) this.tiempoEnHorasEnIntervalo(inicio, fin) * potencia;
	}

}
