package dispositivo;

import java.time.LocalDateTime;

import dispositivo.estados.EstadoDispositivo;

public interface DispositivoInteligente {

    public Long consumoMensual();
    public void activarAhorroDeEnergia();
    public void agregarModulo();
    public void agregarEstado(EstadoDispositivo estado);
    public void setEstado(EstadoDispositivo estado);
    public void apagate();
    public void encendete();
    public boolean estaEncendido();
    public boolean estaApagado() ;
    public EstadoDispositivo getEstado() ;
    public Long calcularConsumoUltimasNHoras(Long horas);
    public Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin);

    ///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

    public Long 					getkWh();
    public String 					getName();

    //////////////////////////////////// SETTERS ////////////////////////////////////

    public void setName(String name);
    public void 					setkWh(Long kWh);
}
