package dispositivo;

import exceptionDispositivo.dispositivoInteligente.NoSePuedeAgregarOtroModuloAdicionalException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;
import dispositivosConcretos.DispositivoConcreto;

public class Modulo implements DispositivoInteligenteInterfaz {

    DispositivoBase dispositivoEstandar;
    private EstadoDispositivo estado;
    private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();


    ///////////////// CONSTRUCTOR /////////////////////////////////////////////////////

    public Modulo(DispositivoBase dispositivoEstandar,EstadoDispositivo estadoDispositivo){
        this.dispositivoEstandar = dispositivoEstandar;
        this.setEstado(estadoDispositivo);
    }

    //////////////// SETTERS Y GETTERS ////////////////


    public EstadoDispositivo getEstado() {      return this.estado;  }

    public void setEstado(EstadoDispositivo estado) {    this.estado = estado;  }

    public void agregarEstado(EstadoDispositivo estado) { estadosAnteriores.add(estado); }
    public String getName(){return this.dispositivoEstandar.getName();}
    public void setName(String name){this.dispositivoEstandar.setName(name);}
    public void setkWh(Long kWh){this.dispositivoEstandar.setkWh(kWh);}
    public void setBajoConsumo(boolean bajoConsumo) {this.dispositivoEstandar.setBajoConsumo(bajoConsumo);}


    public Long getkWh(){return this.dispositivoEstandar.getkWh();}


    ///////////////////// METODOS /////////////////////

    public void agregarModulo(){throw new NoSePuedeAgregarOtroModuloAdicionalException(this);}

    public Long consumoMensual() {
        return calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
    }

    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
        ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
        Long kWh = this.dispositivoEstandar.getkWh();

        estadosAnteriores.stream().filter(estado -> estado.estaComprendido(inicio, fin))
                .forEach(estado -> estadosCompletosPeriodo.add(estado));
        estadosAnteriores.stream().filter(estado -> estado.esCasoBorder(inicio, fin))
                .forEach(estado -> estadosBordePeriodo.add(estado));

        return estadosCompletosPeriodo.stream().mapToLong(estado -> estado.calcularConsumo(kWh)).sum()
                + estadosBordePeriodo.stream().mapToLong(estado -> estado.calcularConsumoBorder(inicio, fin, kWh)).sum();
    }


    public Long calcularConsumoUltimasNHoras(Long horas) {
        return this.calcularConsumoPeriodo(LocalDateTime.now().minusHours(horas), LocalDateTime.now());
    }



    public boolean estaEncendido() {  return estado.estaEncendido(); }

    public boolean estaApagado() {return estado.estaApagado();  }

    public void encendete() { estado.encendete(this); }
    
    public void apagate() {estado.apagate(this);}

    public void activarAhorroDeEnergia() { estado.activarAhorroDeEnergia(this); }
    
    public boolean esInteligente() {return true;}



}
