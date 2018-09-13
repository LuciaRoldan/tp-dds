package dispositivo.estados;

import dispositivo.DispositivoInteligenteAbstracto;
import dispositivo.DispositivoInteligente;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class EstadoDispositivo {
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	public int idEstado;



	public int getIdEstado() {
		return idEstado;
	}

	public boolean estaEncendido() {
		return false;
	}

	public boolean estaApagado() {
		return false;
	}

	public void apagate(DispositivoInteligenteAbstracto dispositivo) {
	}

	public void encendete(DispositivoInteligenteAbstracto dispositivo) {
	}

	public void activarAhorroDeEnergia(DispositivoInteligenteAbstracto dispositivoInteligenteConcreto) {
	}
	
	public double calcularConsumo(double potencia) {
		return 0;
	}

	public LocalDateTime getFin() {
		return null;
	}

	public LocalDateTime getInicio() {
		return null;
	}
	
	public boolean estaComprendido(LocalDateTime inicio, LocalDateTime fin) {
		return false;
	}

	public double calcularConsumoBorder(LocalDateTime inicio, LocalDateTime fin, double potencia) {
		return 0;
	}

	public boolean esCasoBorder(LocalDateTime inicio, LocalDateTime fin) {
		return false;
	}

}
