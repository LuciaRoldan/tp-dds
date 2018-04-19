package categorias;

//R9 C>1400 CARGO FIJO = 887,19 // CARGO VARIABLE = 0,851

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")

public class CategoriaR9 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =   0.851;
    private static Double CARGOFIJO     =  887.19;
    private static Double CONSUMOMAXIMO =   -1.00;  //NO TIENE CONSUMO MAXIMO
    private static Double CONSUMOMINIMO = 1400.00;

    @Override
    public Boolean pertenece(Double consumo) { return (CONSUMOMINIMO < consumo);}

    @Override
    public String getNombre(){return "CategoriaR9";}
    
}