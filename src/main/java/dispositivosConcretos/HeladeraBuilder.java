package dispositivosConcretos;

import dispositivo.DispositivoBuilder;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligente;
import dispositivo.DispositivoInteligenteConcreto;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispEstandarException;
import exceptionDispositivo.dispositivoBuilder.NoSePuedeCrearDispInteligenteExeption;

public class HeladeraBuilder extends DispositivoBuilder {
	
	Boolean tieneFreezer;
	
	
	public DispositivoInteligente construirInteligente() {
		if(this.getConsumoPorHora() == -1L || this.getEstadoDispositivo() == null) {
			throw new NoSePuedeCrearDispInteligenteExeption(this);
		} else {
			if (this.tieneFreezer) {
				return new HeladeraInteligente(this.getNombre(), this.getEstadoDispositivo(), (long) 0.09,
						this.getUsoMensualMinimo(), this.getUsoMensualMaximo(), true, this.tieneFreezer);
			} else {
				return new HeladeraInteligente(this.getNombre(), this.getEstadoDispositivo(), (long) 0.075,
						this.getUsoMensualMinimo(), this.getUsoMensualMaximo(), true, this.tieneFreezer);
			}
		}
	}
	
	public DispositivoEstandar construirEstandar() {
		throw new NoSePuedeCrearDispEstandarException(this);
	}
	
}

/*
	public DispositivoInteligente construirInteligente() {

		if(this.getConsumoPorHora() == -1L || this.getEstadoDispositivo() == null) {
			throw new NoSePuedeCrearDispInteligenteExeption(this);
		}else {
			if (this.getModulo() == false) {
				return (new HeladeraInteligente(this.getNombre(), this.getEstadoDispositivo(), this.getConsumoPorHora(),
						this.getUsoMensualMinimo(), this.getUsoMensualMaximo(), this.tieneFreezer));
			} else {
				return (new Modulo(new HeladeraEstandar(this.getConsumoPorHora(), this.getNombre(),
						this.getUsoMensualMinimo(), this.getUsoMensualMaximo(), this.tieneFreezer)));
			}
		}
	}

	public DispositivoEstandar construirEstandar(){
		if (this.getConsumoPorHora() == -1L || this.getNombre() == null){
			throw new NoSePuedeCrearDispEstandarException(this);
		}else {
			return (new HeladeraEstandar(this.getConsumoPorHora(), this.getNombre(),
					this.getUsoMensualMinimo(), this.getUsoMensualMaximo(), this.tieneFreezer));
		}
	}
*/
