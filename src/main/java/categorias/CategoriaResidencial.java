package categorias;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.xpath.internal.objects.XObject;
import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({

        @JsonSubTypes.Type(value= CategoriaR9.class, name="CategoriaR9"),

})
public abstract class CategoriaResidencial {


    private List<CategoriaResidencial> listaClases = new ArrayList<CategoriaResidencial>();


    public Double cargoVariable(){return null;}
    public Double cargoFijo(){return null;}
    public Boolean pertenece(double consumo){return null;}
    public CategoriaResidencial getCategoria(){return null;}
    public String getNombre(){return null;}

    @JsonCreator
    public CategoriaResidencial fromString(String tipoCategoria) {

        this.listaClases.add(CategoriaR9.class);
        this.listaClases.add(CategoriaR8.class);
        listaClases.add(CategoriaR7.class);
        listaClases.add(CategoriaR6.class);
        listaClases.add(CategoriaR5.class);
        listaClases.add(CategoriaR4.class);
        listaClases.add(CategoriaR3.class);
        listaClases.add(CategoriaR2.class);
        listaClases.add(CategoriaR1.class);

        CategoriaResidencial categoria = (CategoriaResidencial) this.listaClases.stream().filter(cat -> ! (cat.getNombre()).equals(tipoCategoria));

      return categoria;



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
    }