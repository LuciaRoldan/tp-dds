package dispositivo;

import estadoDispositivo.EstadoDispositivo;

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

    ///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

    public Long 					getkWh();
    public String 					getName();

    //////////////////////////////////// SETTERS ////////////////////////////////////

    public void 					setNombre(String nombre);
    public void 					setkWh(Long kWh);
}
