package categorias;//  R7 600<C<=700 cargo fijo 443,59 cargo variable 0,851


import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR7 extends CategoriaResidencial {

    public Double cargoVariable() { return 0.851; }
    public Double cargoFijo() {return 443.59;}

    @Override
    public Boolean pertenece(double consumo) {return ((600 < consumo) && (consumo <= 700));}



}
