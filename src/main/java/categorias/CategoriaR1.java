package categorias;

//R1 C<= 150 ; Cargo fijo = 18,76 Cargo variable = 0,644

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR1 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.644;
    private static Double CARGOFIJO     =  18.76;
    private static Double CONSUMOMAXIMO = 150.00;
    private static Double CONSUMOMINIMO =   0.00;

    @Override
    public Boolean pertenece(Double consumo) { return (consumo <= CONSUMOMAXIMO);}

    @Override
    public String getNombre(){return "CategoriaR1";}
}
