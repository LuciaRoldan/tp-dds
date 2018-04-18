package categorias;//R3 325<C<=400 cargo fijo = 60,71 cargo variable = 0,681


import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR3 implements CategoriaResidencial {

    @Override
    public Double cargoVariable() {return 0.681;}

    @Override
    public Double cargoFijo() { return 60.71; }

    @Override
    public Boolean pertenece(double consumo) {return ((325 < consumo) && (consumo <= 400));}

}
