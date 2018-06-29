package dispositivosConcretos;
import java.time.LocalDateTime;

import dispositivo.DispositivoBase;
import dispositivo.estados.EstadoDispositivo;

public abstract class DispositivoConcreto {
	
	DispositivoBase dispositivoBase;
	
	DispositivoConcreto(DispositivoBase dispositivoBase){
		this.dispositivoBase = dispositivoBase;
	}
	
    public Long consumoMensual() { return dispositivoBase.consumoMensual(); }
    public void activarAhorroDeEnergia() { this.dispositivoBase.activarAhorroDeEnergia(); }
    public void agregarEstado(EstadoDispositivo estado) {this.dispositivoBase.agregarEstado(estado);}
    public void setEstado(EstadoDispositivo estado) { this.dispositivoBase.setEstado(estado);}
    public void apagate() { this.dispositivoBase.apagate(); }
    public void encendete() {this.dispositivoBase.encendete(); }
    public boolean estaEncendido() {return this.dispositivoBase.estaEncendido();}
    public boolean estaApagado() {return this.dispositivoBase.estaApagado();}
    public EstadoDispositivo getEstado() {return this.dispositivoBase.getEstado();}
    public Long calcularConsumoUltimasNHoras(Long horas) {return this.dispositivoBase.calcularConsumoUltimasNHoras(horas);}
    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {return this.dispositivoBase.calcularConsumoPeriodo(inicio, fin);}
	
}
