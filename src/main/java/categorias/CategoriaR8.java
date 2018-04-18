package categorias;

//R8 700<C<= 1400 cargo fijo 545,96 cargo variable 0,851


import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR8 implements CategoriaResidencial {

    private static Double CARGOVARIABLE = 0.851;
    private static Double CARGOFIJO = 545.96;
    @Override
    public Double cargoVariable() {
        return CARGOVARIABLE;
    }

    @Override
    public Double cargoFijo() { return CARGOFIJO; }

    @Override
    public Boolean pertenece(double consumo) { return ((700 < consumo) && (consumo <= 1400));}
}
