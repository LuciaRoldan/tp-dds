package categorias;// R1 C<= 150 ; Cargo fijo = 18,76 Cargo variable = 0,644


import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
public class CategoriaR1 extends CategoriaResidencial {

    @Override
    public Double cargoVariable() { return 0.644; }

    @Override
    public Double cargoFijo() { return 18.76;}

    @Override
    public Boolean pertenece(double consumo) { return (consumo <= 150);}
}
