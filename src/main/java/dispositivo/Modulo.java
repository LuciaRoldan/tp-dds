package dispositivo;

import exceptionDispositivo.dispositivoInteligente.NoSePuedeAgregarOtroModuloAdicionalException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dispositivo.estados.EstadoDispositivo;

public class Modulo implements DispositivoInteligente {

    DispositivoEstandar dispositivoEstandar;
    private EstadoDispositivo estado;
    private ArrayList<EstadoDispositivo> estadosAnteriores = new ArrayList<EstadoDispositivo>();


    ///////////////// CONSTRUCTOR /////////////////////////////////////////////////////

    public Modulo(DispositivoEstandar de,EstadoDispositivo estadoDispositivo){
        this.dispositivoEstandar = de;
        this.setEstado(estadoDispositivo);
    }

    //////////////// SETTERS Y GETTERS ////////////////


    public EstadoDispositivo getEstado() {      return this.estado;  }

    public void setEstado(EstadoDispositivo estado) {    this.estado = estado;  }

    public void agregarEstado(EstadoDispositivo estado) { estadosAnteriores.add(estado); }
    public String getName(){return this.dispositivoEstandar.getName();}
    public void setName(String name){this.dispositivoEstandar.setName(name);}
    public void setkWh(Long kWh){this.dispositivoEstandar.setConsumoPorHora(kWh);}


    public Long getkWh(){return this.dispositivoEstandar.getConsumoPorHora();}


    ///////////////////// METODOS /////////////////////

    public void agregarModulo(){throw new NoSePuedeAgregarOtroModuloAdicionalException(this);}

    public Long consumoMensual() {
        return calcularConsumoPeriodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now());
    }

    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        ArrayList<EstadoDispositivo> estadosCompletosPeriodo = new ArrayList<EstadoDispositivo>();
        ArrayList<EstadoDispositivo> estadosBordePeriodo = new ArrayList<EstadoDispositivo>();
        Long kWh = this.dispositivoEstandar.getConsumoPorHora();

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



}
