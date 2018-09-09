package dispositivo.estados;

import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;
import dispositivo.*;

import java.time.LocalDateTime;

public class Apagado extends EstadoDispositivo {

	
	public Apagado() {
		inicio = LocalDateTime.now();
	}

	public boolean estaEncendido() {
		return false;
	}

	public boolean estaApagado() {
		return true;
	}

	public void apagate(DispositivoInteligenteInterfaz dispositivo) {
	}

	public void encendete(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}


	public void activarAhorroDeEnergia(DispositivoInteligenteInterfaz dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new AhorroDeEnergia());
	}
	
	public double consumoTotal(double potencia) {
		return 0;
	}

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, double potencia) {
		return 0;
	}

}
