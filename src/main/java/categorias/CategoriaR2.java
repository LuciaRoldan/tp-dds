package categorias;

// R2 150 < C <= 325 cargo fijo = 35,32  cargo variable = 0,644

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR2 implements CategoriaResidencial {
    public Double cargoVariable() { return 0.644; }

    @Override
    public Double cargoFijo() { return 35.32;}

    @Override
    public Boolean pertenece(double consumo) { return ((150 < consumo) && (consumo <= 325)); }
}
