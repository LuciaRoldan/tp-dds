package dispositivo;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispEstandarException;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispInteligenteExeption;

public abstract class DispositivoBuilder {

	private String nombre = null;
	private Long consumoPorHora = -1L;
	private EstadoDispositivo estadoDispositivo = null;
	private Boolean modulo = false;
	private double usoMensualMinimo;
	private double usoMensualMaximo;
	private boolean esBajoConsumo;
	

	public void setName(String name){this.nombre = name;}
	public void setConsumoHora(Long horas){this.consumoPorHora = horas;}
	public void setEstadoInicial(EstadoDispositivo ed){this.estadoDispositivo = ed;}
	public void agregarModulo(){this.modulo = true;}
	public void setUsoMensualMinimo(double consumo) {this.usoMensualMinimo = consumo;}
	public void setUsoMensualMaximo(double consumo) {this.usoMensualMaximo = consumo;}
	public void setEsBajoConsumo(boolean esBajoConsumo) {
		this.esBajoConsumo = esBajoConsumo;
	}

	
	
	public String getNombre() {return this.nombre;}
	public Long getConsumoPorHora() { return this.consumoPorHora;}
	public EstadoDispositivo getEstadoDispositivo() {return this.estadoDispositivo;}
	public Boolean getModulo() {return this.modulo;}
	public double getUsoMensualMinimo() {return this.usoMensualMinimo;}
	public double getUsoMensualMaximo() {return this.usoMensualMaximo;}
	public boolean getEsBajoConsumo() {
		return esBajoConsumo;
	}
	

	public abstract DispositivoInteligente construirInteligente();
	public abstract DispositivoEstandar construirEstandar();

}
