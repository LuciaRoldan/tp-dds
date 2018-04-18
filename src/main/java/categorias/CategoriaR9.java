package categorias;


// R9 C>1400 CARGO FIJO = 887,19 // CARGO VARIABLE = 0,851

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR9 implements CategoriaResidencial {
    @Override
    public Double cargoVariable() {return 0.851; }

    @Override
    public Double cargoFijo(){return 887.19;}

    @Override
    public Boolean pertenece(double consumo) {return (consumo >1400);}


}
