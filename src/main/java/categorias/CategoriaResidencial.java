package categorias;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({

        @JsonSubTypes.Type(value=CategoriaR9.class),
        @JsonSubTypes.Type(value=CategoriaR8.class),
        @JsonSubTypes.Type(value=CategoriaR7.class),
        @JsonSubTypes.Type(value=CategoriaR6.class),
        @JsonSubTypes.Type(value=CategoriaR5.class),
        @JsonSubTypes.Type(value=CategoriaR4.class),
        @JsonSubTypes.Type(value=CategoriaR3.class),
        @JsonSubTypes.Type(value=CategoriaR2.class),
        @JsonSubTypes.Type(value=CategoriaR1.class)
})
public interface CategoriaResidencial {

    public Double cargoVariable();
    public Double cargoFijo();
    public Boolean pertenece(double consumo);

}
/*CATEGORIAS:
  R1 C<= 150 ; Cargo fijo = 18,76 Cargo variable = 0,644
  R2 150 < C <= 325 cargo fijo = 35,32  cargo variable = 0,644
  R3 325<C<=400 cargo fijo = 60,71 cargo variable = 0,681
  R4 400<C<=450 cargo fijo = 71,74 cargo variable 0,738
  R5 450<C<500 cargo fijo 110,38 cargo variable 0,794
  R6 500<C<=600 Cargo fijo 220,75 cargo variable 0,832
  R7 600<C<=700 cargo fijo 443,59 cargo variable 0,851
  R8 700<C<= 1400 cargo fijo 545,96 cargo variable 0,851
  R9 C>1400 cargo fijo 887,19 cargo variable 0,851
  */