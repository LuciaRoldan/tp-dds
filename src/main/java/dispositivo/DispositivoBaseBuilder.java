package dispositivo;

import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispEstandarException;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispInteligenteExeption;

public class DispositivoBaseBuilder {

	private String nombre = null;
	private Long consumoPorHora = -1L;
	private Long horasDeUsoPorDia = -1L;
	private EstadoDispositivo estadoDispositivo = null;
	private Boolean modulo = false;



	public void setName(String name){this.nombre = name;}
	public void setConsumoHora(Long horas){this.consumoPorHora = horas;}
	public void setHorasUsoDia(Long horas){this.horasDeUsoPorDia = horas;}
	public void setEstadoInicial(EstadoDispositivo ed){this.estadoDispositivo = ed;}
	public void agregarModulo(){this.modulo = true;}

	public DispositivoInteligente construirInteligente() {

		if(this.nombre == null || this.consumoPorHora == -1L || this.estadoDispositivo == null) {
			throw new NoSePuedeCrearDispInteligenteExeption(this);
		}else{

			if (modulo == false) {
				return (new DispositivoInteligenteConcreto(this.nombre, this.estadoDispositivo, this.consumoPorHora));
			} else {
				if (horasDeUsoPorDia == -1L){
					throw new NoSePuedeCrearDispInteligenteExeption(this);
				}
				return (new Modulo(new DispositivoEstandar(this.consumoPorHora, this.nombre, this.horasDeUsoPorDia),this.estadoDispositivo));
			}
		}
	}

	public DispositivoEstandar construirEstandar(){
		if (this.consumoPorHora == -1L || this.nombre == null || this.horasDeUsoPorDia == -1L){
			throw new NoSePuedeCrearDispEstandarException(this);
		}else {
			return (new DispositivoEstandar(this.consumoPorHora, this.nombre, this.horasDeUsoPorDia));
		}
	}

}