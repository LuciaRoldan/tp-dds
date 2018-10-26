package dispositivosConcretos;
import java.time.LocalDateTime;
import java.util.List;

import dispositivo.DispositivoBase;
import dispositivo.Modulo;
import dispositivo.estados.EstadoDispositivo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class DispositivoConcreto {
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	DispositivoBase dispositivoBase;
	double consumoIdeal;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer numeroDeDispositivoConcreto;

	public DispositivoConcreto(){};
	DispositivoConcreto(DispositivoBase dispositivoBase){
		this.dispositivoBase = dispositivoBase;
	}

	public Integer getId(){return this.numeroDeDispositivoConcreto;}
	public double consumoPromedioPorHora(LocalDateTime inicio, LocalDateTime fin) { return this.dispositivoBase.consumoPromedioPorHora(inicio, fin);}
	public double consumoMensual() { return dispositivoBase.consumoMensual(); }
    public void activarAhorroDeEnergia() { this.dispositivoBase.activarAhorroDeEnergia(); }
    public void agregarEstado(EstadoDispositivo estado) {this.dispositivoBase.agregarEstado(estado);}
    public void setEstado(EstadoDispositivo estado) { this.dispositivoBase.setEstado(estado);}
    public void apagate() { this.dispositivoBase.apagate(); }
    public void encendete() {this.dispositivoBase.encendete(); }
    public boolean estaEncendido() {return this.dispositivoBase.estaEncendido();}
    public boolean estaApagado() {return this.dispositivoBase.estaApagado();}
    public boolean esInteligente() {return this.dispositivoBase.esInteligente();}
    public EstadoDispositivo getEstado() {return this.dispositivoBase.getEstado();}
    public double calcularConsumoUltimasNHoras(int horas) {return this.dispositivoBase.calcularConsumoUltimasNHoras(horas);}
    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {return this.dispositivoBase.calcularConsumoPeriodo(inicio, fin);}
	public void agregarModulo(EstadoDispositivo estadoDispositivo) {this.dispositivoBase = new Modulo(dispositivoBase, estadoDispositivo);}
	public double getConsumoIdeal() {return this.consumoIdeal;}
	public void setConsumoIdeal(double consumoIdeal) {this.consumoIdeal = consumoIdeal;}
	public String getName() {return this.dispositivoBase.getName();}
	public void setPotencia(double potencia) {this.dispositivoBase.setPotencia(potencia);}
	public void setName(String name) {this.dispositivoBase.setName(name);}
	public double getPotencia() {return this.dispositivoBase.getPotencia();}
	public void setBajoConsumo(boolean bajoConsumo) {this.dispositivoBase.setBajoConsumo(bajoConsumo);}
	public double getUsoMensualMaximo() {return this.dispositivoBase.getUsoMensualMaximo();}
	public double getUsoMensualMinimo() {return this.dispositivoBase.getUsoMensualMinimo();}
	public double getHorasDeUsoIdeal() {return this.dispositivoBase.getHorasDeUsoIdeal();}
	public double consumoCorriente() { return this.dispositivoBase.consumoCorriente();}
	public List<EstadoDispositivo> getEstadosAnteriores(){ return this.dispositivoBase.getEstadosAnteriores();}
	public double consumoCorrienteMock() {return this.dispositivoBase.consumoCorrienteMock();}
	public String getEsBajoConsumoBoolean() {return this.dispositivoBase.getEsBajoConsumoBoolean();}
	public String getEstadoString() {return this.dispositivoBase.getEstadoString();}
	public String getConsumoIdealString() {return String.valueOf(this.getConsumoIdeal());}
	public String getPotenciaString() {return String.valueOf(this.dispositivoBase.getPotencia());}
}