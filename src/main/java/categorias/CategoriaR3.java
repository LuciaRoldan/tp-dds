package categorias;

//R3 325<C<=400 cargo fijo = 60,71 cargo variable = 0,681

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR3 extends CategoriaResidencial {

    private static Double CARGOVARIABLE =  0.681;
    private static Double CARGOFIJO     =  60.71;
    private static Double CONSUMOMAXIMO = 400.00;
    private static Double CONSUMOMINIMO = 325.00;

    @Override
    public Double cargoVariable() {
        return CARGOVARIABLE;
    }

    @Override
    public Double cargoFijo() { return CARGOFIJO; }

    @Override
    public Boolean pertenece(Double consumo) { return ((CONSUMOMINIMO < consumo) && (consumo <= CONSUMOMAXIMO));}

    @Override
    public String getNombre(){return "CategoriaR3";}

}
