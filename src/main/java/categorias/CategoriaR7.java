package categorias;

//R7 600<C<=700 cargo fijo 443,59 cargo variable 0,851

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR7 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.851;
    private static Double CARGOFIJO     = 443.59;
    private static Double CONSUMOMAXIMO = 700.00;
    private static Double CONSUMOMINIMO = 600.00;


    public Double getCargoVariable() {
        return this.CARGOVARIABLE;
    }
    public Double getCargoFijo()     { return this.CARGOFIJO    ; }
    public String getNombre()        { return "CATEGORIAR7";}

    public Boolean pertenece(Double consumo){
        return ((this.CONSUMOMINIMO < consumo) && (consumo <= this.CONSUMOMAXIMO));
    }
    

    
}
