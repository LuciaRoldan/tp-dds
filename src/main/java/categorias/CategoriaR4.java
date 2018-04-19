package categorias;

//R4 400<C<=450 cargo fijo = 71,74 cargo variable 0,738

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR4 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.738;
    private static Double CARGOFIJO     =  71.74;
    private static Double CONSUMOMAXIMO = 450.00;
    private static Double CONSUMOMINIMO = 400.00;

    @Override
    public String getNombre(){return "CategoriaR4";}
}
