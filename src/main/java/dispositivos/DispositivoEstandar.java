package dispositivos;

import java.time.LocalDateTime;

import Excepciones.NoSePuedeCalcularElConsumoException;
import Excepciones.NoSePuedeConocerElEstadoDelEstandarException;

public class DispositivoEstandar extends TipoDeDispositivo {
	
	private int horasDeUsoPorDia;
	
	public DispositivoEstandar() {
	}
	
	@Override
	public Long consumoMensual(Long kWh) {
		return kWh * horasDeUsoPorDia * 30;
	}

	@Override
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
	@Override
	public boolean estaEncendido() {
		return false;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public void encendete() {}

	@Override
	public void apagate() {}

	@Override
	public void activarAhorroDeEnergia() {}

	@Override
	public String getNombre() {
		return "ESTANDAR";
	}
	@Override
	public Estado getEstado() {
		throw new NoSePuedeConocerElEstadoDelEstandarException();
	}

	@Override
	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException();
	}

	@Override
	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException();
	}

	@Override
	public void setEstado(Estado estado) {
		
	}

	@Override
	public void agregarEstado(Estado estado) {
		
	}

}
