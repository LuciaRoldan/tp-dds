package dispositivo.estados;

import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteAbstracto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
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


	
	public void apagate(DispositivoInteligenteAbstracto dispositivo) {
	}


	@Override
	public void encendete(DispositivoInteligenteAbstracto dispositivo) {
		fin = LocalDateTime.now();		
		dispositivo.agregarEstado(this);
		dispositivo.setEstado(new Encendido());
	}



	public double consumoTotal(double potencia) {
		return 0;
	}

	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, double potencia) {
		return 0;
	}

	@Override
	public void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivoInteligenteConcreto) {
		// TODO Auto-generated method stub
		
	}

}
