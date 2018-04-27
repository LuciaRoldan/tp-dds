package categorias;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR3 extends CategoriaResidencial {

    //R3 325<C<=400 cargo fijo = 60,71 cargo variable = 0,681

    private static Double CARGOVARIABLE =  0.681;
    private static Double CARGOFIJO     =  60.71;
    private static Double CONSUMOMAXIMO = 400.00;
    private static Double CONSUMOMINIMO = 325.00;

    public Double  getCargoVariable()       { return this.CARGOVARIABLE; }
    public Double  getCargoFijo()           { return this.CARGOFIJO    ; }
    public String  getNombre()              { return "CATEGORIAR3";}
    public Boolean pertenece(Double consumo){ return ((this.CONSUMOMINIMO < consumo) && (consumo <= this.CONSUMOMAXIMO));}


}
