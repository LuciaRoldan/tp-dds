package dispositivo;

import java.time.LocalDateTime;

import dispositivo.estados.EstadoDispositivo;

public interface DispositivoInteligenteInterfaz extends DispositivoBase{

    public double consumoMensual();
    public void activarAhorroDeEnergia();
    public void agregarEstado(EstadoDispositivo estado);
    public void setEstado(EstadoDispositivo estado);
    public void apagate();
    public void encendete();
    public boolean estaEncendido();
    public boolean estaApagado() ;
    public EstadoDispositivo getEstado() ;
    public double calcularConsumoUltimasNHoras(int horas);
    public double calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin);

    ///////////////////////////////////// GETTERS PARA LOS TESTS ////////////////////////

    public double 					getPotencia();
    public String 					getName();

    //////////////////////////////////// SETTERS ////////////////////////////////////

    public void setName(String name);
    public void setPotencia(double potencia);
}
