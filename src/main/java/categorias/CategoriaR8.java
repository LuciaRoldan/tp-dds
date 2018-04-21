package categorias;

//R8 700<C<=1400 cargo fijo 545,96 cargo variable 0,851

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR8 extends CategoriaResidencial {

    private static Double CARGOVARIABLE = 0.851;
    private static Double CARGOFIJO     = 545.96;
    private static Double CONSUMOMAXIMO = 1400.00;
    private static Double CONSUMOMINIMO = 700.00;


    public Double getCargoVariable() {
        return this.CARGOVARIABLE;
    }

    public Double getCargoFijo() {
        return this.CARGOFIJO;
    }

    public Boolean pertenece(Double consumo){
        return ((this.CONSUMOMINIMO < consumo) && (consumo <= this.CONSUMOMAXIMO));
    }

    @Override
    public String getNombre(){return "CATEGORIAR8";}

}