package categorias;

// R2 150 < C <= 325 cargo fijo = 35,32  cargo variable = 0,644

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR2 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.644;
    private static Double CARGOFIJO     =  35.32;
    private static Double CONSUMOMAXIMO = 325.00;
    private static Double CONSUMOMINIMO = 150.00;

    @Override
    public Double cargoVariable() {
        return CARGOVARIABLE;
    }

    @Override
    public Double cargoFijo() { return CARGOFIJO; }

    @Override
    public Boolean pertenece(Double consumo) { return ((CONSUMOMINIMO < consumo) && (consumo <= CONSUMOMAXIMO));}

    @Override
    public String getNombre(){return "CategoriaR2";}
}
