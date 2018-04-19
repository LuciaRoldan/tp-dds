package categorias;

//R6 500<C<=600 CARGO FIJO =220,75 // CARGO VARIABLE = 0,832

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR6 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.832;
    private static Double CARGOFIJO     = 220.75;
    private static Double CONSUMOMAXIMO = 600.00;
    private static Double CONSUMOMINIMO = 500.00;

    @Override
    public String getNombre(){return "CategoriaR6";}
    
}
