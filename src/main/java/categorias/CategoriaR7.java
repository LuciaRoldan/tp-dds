package categorias;

//  R7 600<C<=700 cargo fijo 443,59 cargo variable 0,851

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR7 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.851;
    private static Double CARGOFIJO     = 443.59;
    private static Double CONSUMOMAXIMO = 700.00;
    private static Double CONSUMOMINIMO = 600.00;

    @Override
    public Double cargoVariable() {
        return CARGOVARIABLE;
    }

    @Override
    public Double cargoFijo() { return CARGOFIJO; }

    @Override
    public Boolean pertenece(Double consumo) { return ((CONSUMOMINIMO < consumo) && (consumo <= CONSUMOMAXIMO));}

    @Override
    public String getNombre(){return "CategoriaR7";}



}
