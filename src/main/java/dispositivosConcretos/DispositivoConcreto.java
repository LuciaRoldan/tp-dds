package dispositivosConcretos;
import java.time.LocalDateTime;

import dispositivo.DispositivoBase;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;

public abstract class DispositivoConcreto {
	
	DispositivoBase dispositivoBase;
	double consumoIdeal;
	
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
    public boolean esInteligente() {return this.dispositivoBase.esInteligente();}
    public EstadoDispositivo getEstado() {return this.dispositivoBase.getEstado();}
    public Long calcularConsumoUltimasNHoras(Long horas) {return this.dispositivoBase.calcularConsumoUltimasNHoras(horas);}
    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {return this.dispositivoBase.calcularConsumoPeriodo(inicio, fin);}
	public void agregarModulo(EstadoDispositivo estadoDispositivo) {this.dispositivoBase = new Modulo(dispositivoBase, estadoDispositivo);}
	public double getConsumoIdeal() {return this.consumoIdeal;}
	public void setConsumoIdeal(double consumoIdeal) {this.consumoIdeal = consumoIdeal;}
	public String getName() {return this.dispositivoBase.getName();}
	public void setkWh(Long kWh) {this.dispositivoBase.setkWh(kWh);}
	public void setName(String name) {this.dispositivoBase.setName(name);}
	public Long getkWh() {return this.dispositivoBase.getkWh();}
	public void setBajoConsumo(boolean bajoConsumo) {this.dispositivoBase.setBajoConsumo(bajoConsumo);}
	public double getUsoMensualMaximo() {return this.dispositivoBase.getUsoMensualMaximo();}
	public double getUsoMensualMinimo() {return this.dispositivoBase.getUsoMensualMinimo();}

}

