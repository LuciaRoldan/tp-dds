package categorias;

//R5 450<C<500 cargo fijo 110,38 cargo variable 0,794

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR5 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.794;
    private static Double CARGOFIJO     = 110.38;
    private static Double CONSUMOMAXIMO = 500.00;
    private static Double CONSUMOMINIMO = 450.00;


    public Double getCargoVariable() {
        return this.CARGOVARIABLE;
    }
    public Double getCargoFijo()     { return this.CARGOFIJO    ; }
    public String getNombre()        { return "CATEGORIAR5";}

    public Boolean pertenece(Double consumo){
        return ((this.CONSUMOMINIMO < consumo) && (consumo <= this.CONSUMOMAXIMO));
    }
    

}
