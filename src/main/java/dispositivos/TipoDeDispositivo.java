package dispositivos;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= DispositivoInteligente.class, name="dispositivoInteligente"),
})
public abstract class  TipoDeDispositivo {

    public String    getNombre()     {return null;}
    
    public abstract Long consumoMensual(Long kwh);
    public abstract boolean esInteligente();
    public abstract boolean estaEncendido();
    public abstract boolean estaApagado();
    public abstract void encendete();
    public abstract void apagate();
    public abstract void activarAhorroDeEnergia();
    public abstract EstadoDispositivo getEstado();
    public abstract Long calcularConsumoPeriodo(LocalDateTime inicio, LocalDateTime fin, Long kWh);
    public abstract Long calcularConsumoUltimasNHoras(int horas, Long kWh);
    public abstract void setEstado(EstadoDispositivo estado);
    public abstract void setHorasDeUsoPorDia(int horasDeUsoPorDia);
    public abstract void agregarEstado(EstadoDispositivo estado);
    
  
}
