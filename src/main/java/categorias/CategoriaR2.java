package categorias;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR2 extends CategoriaResidencial {

    //R2 150 < C <= 325 cargo fijo = 35,32  cargo variable = 0,644


    private static Double CARGOVARIABLE =  0.644;
    private static Double CARGOFIJO     =  35.32;
    private static Double CONSUMOMAXIMO = 325.00;
    private static Double CONSUMOMINIMO = 150.00;

    public Double getCargoVariable() {
        return this.CARGOVARIABLE;
    }
    public Double getCargoFijo()     { return this.CARGOFIJO    ; }
    public String getNombre()        { return "CATEGORIAR2";}
    public Boolean pertenece(Double consumo){
        return ((this.CONSUMOMINIMO < consumo) && (consumo <= this.CONSUMOMAXIMO));
    }
    

}
