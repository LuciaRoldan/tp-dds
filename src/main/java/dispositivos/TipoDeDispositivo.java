package dispositivos;
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
    public abstract Estado getEstado();

  
}
