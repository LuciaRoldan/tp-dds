package dispositivo;

import java.time.LocalDateTime;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.dispositivoEstandar.NoSePuedeCalcularElConsumoException;

public class DispositivoEstandar implements DispositivoBase {
	
	private String name;
	private Long kWh;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private double potencia;
	private boolean esBajoConsumo;
	

	public DispositivoEstandar(Long kWh,String name, double usoMensualMinimo, double usoMensualMaximo){
		this.kWh = kWh;
		this. name = name;
		this.setUsoMensualMinimo(usoMensualMinimo);
		this.setUsoMensualMaximo(usoMensualMaximo);
	}
	

	///////////// GETTERS/////////////

	public String getName() {return this.name;}

	public Long getkWh(){return this.kWh;}
	
	public double getUsoMensualMaximo() {
		return usoMensualMaximo;
	}
	
	public double getUsoMensualMinimo() {
		return usoMensualMinimo;
	}


	///////////// SETTERS/////////////

	public void setName(String name){this.name = name;}
	
	public void setkWh(Long kWh) {this.kWh = kWh;}
	
	public void setUsoMensualMaximo(double usoMensualMaximo) {
		this.usoMensualMaximo = usoMensualMaximo;
	}
	
	public void setUsoMensualMinimo(double usoMensualMinimo) {
		this.usoMensualMinimo = usoMensualMinimo;
	}
	
	public void setBajoConsumo(boolean bajoConsumo) {
		this.esBajoConsumo = bajoConsumo;
	}


/////////////METODOS/////////////

	public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh) {
		throw new NoSePuedeCalcularElConsumoException(this);
	}
//
//	public Long calcularConsumoUltimasNHoras(int horas, Long kWh) {
//		throw new NoSePuedeCalcularElConsumoException(this);
//	}


	@Override
	public double consumoMensual() {
		return 0; //xd ? 
	}

	@Override
	public void activarAhorroDeEnergia() {
	}

	@Override
	public void setEstado(EstadoDispositivo estado) {
	}

	@Override
	public void apagate() {
	}

	@Override
	public void encendete() {
	}

	@Override
	public boolean estaEncendido() { //que tire excepcion
		return false;
	}

	@Override
	public boolean estaApagado() {
		return false;
	}

	@Override
	public EstadoDispositivo getEstado() {
		return null;
	}

	@Override
	public double calcularConsumoUltimasNHoras(int horas) {
		return 0;
	}

	@Override
	public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
		return 0;
	}
	
	@Override
	public boolean esInteligente() {return false;}


	@Override
	public void agregarEstado(EstadoDispositivo estado) {}


	@Override
	public double getPotencia() {
		return this.getPotencia();
	}


	@Override
	public double getHorasDeUsoIdeal() {
		return this.getHorasDeUsoIdeal();
	}


	@Override
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

}
