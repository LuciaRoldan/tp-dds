package dispositivos;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import static java.util.Arrays.asList;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= DispositivoInteligente.class, name="dispositivoInteligente"),
})
public abstract class  TipoDeDispositivo {

    public String    getNombre()     {return null;}
    
    public abstract Long consumoMensual();
    public abstract boolean esInteligente();

    @JsonCreator
    public static TipoDeDispositivo fromString(String tipoDeDispositivo) {

        List<TipoDeDispositivo> listaClases = asList(new DispositivoInteligente(),new DispositivoEstandar());

        TipoDeDispositivo tipoDisp  =  listaClases.stream()
                .filter(x -> tipoDeDispositivo.equals(x.getNombre()))
                .findAny()
                .orElse(null);

        return tipoDisp;
    }
}
