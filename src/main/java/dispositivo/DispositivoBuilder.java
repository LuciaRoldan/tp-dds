package dispositivo;

import exceptionDispositivo.NoSePuedeAgregarOtroModuloAdicional;

import java.awt.dnd.MouseDragGestureRecognizer;

import dispositivo.estados.EstadoDispositivo;

public class DispositivoBuilder {

	private String nombre;
	private Long consumoPorHora;
	private Long horasDeUsoPorDia;
	private EstadoDispositivo estadoDispositivo;
	private Boolean modulo = false;



	public void setName(String name){this.nombre = name;}
	public void setConsumoHora(Long horas){this.consumoPorHora = horas;}
	public void setHorasUsoDia(Long horas){this.horasDeUsoPorDia = horas;}
	public void setEstadoInicial(EstadoDispositivo ed){this.estadoDispositivo = ed;}
	public void agregarModulo(){this.modulo = true;}

	public DispositivoInteligente construirInteligente() {

		if (modulo == false) {
			return (new DispositivoInteligenteConcreto(this.nombre, this.estadoDispositivo,this.consumoPorHora));
		}else{
			return (new Modulo(new DispositivoEstandar(this.consumoPorHora,this.nombre, this.horasDeUsoPorDia)));
		}

	}

	public DispositivoEstandar construirEstandar(){
		return (new DispositivoEstandar(this.consumoPorHora,this.nombre, this.horasDeUsoPorDia));
	}

	public DispositivoBuilder() {}


}
