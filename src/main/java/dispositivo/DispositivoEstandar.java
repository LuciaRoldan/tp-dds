package dispositivo;

import java.time.LocalDateTime;

import estadoDispositivo.EstadoDispositivo;
import excepcion.NoSePuedeCalcularElConsumoException;
import excepcion.NoSePuedeConocerElEstadoDelEstandarException;

public class DispositivoEstandar  {
	
	private int horasDeUsoPorDia;
	
	public DispositivoEstandar() {
	}
	

	public Long consumoMensual(Long kWh) {
		return kWh * horasDeUsoPorDia * 30;
	}

	public boolean esInteligente() {
		return false;
	}	
	///////////// GETTERS/////////////

	public int getHorasDeUsoPorDia() {
		return horasDeUsoPorDia;
	}

	///////////// SETTERS/////////////

	public void setHorasDeUsoPorDia(int horasDeUsoPorDia) {
		this.horasDeUsoPorDia = horasDeUsoPorDia;
	}

/////////////METODOS/////////////
	public boolean estaEncendido() {
		return false;
	}

	public boolean estaApagado() {
		return false;
	}

	public void encendete() {}

	public void apagate() {}

	public void activarAhorroDeEnergia() {}

	public String getNombre() {
		return "ESTANDAR";
	}

	public EstadoDispositivo getEstado() {
		throw new NoSePuedeConocerElEstadoDelEstandarException();
	}

	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException();
	}

	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException();
	}

	public void setEstado(EstadoDispositivo estado) {
		
	}

	public void agregarEstado(EstadoDispositivo estado) {
		
	}

}
