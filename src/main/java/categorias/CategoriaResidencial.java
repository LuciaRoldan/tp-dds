package categorias;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import static java.util.Arrays.asList;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({

        @JsonSubTypes.Type(value= CategoriaR9.class, name="CategoriaR9"),

})
public abstract class CategoriaResidencial {
	
	private static Double CARGOVARIABLE;
	private static Double CARGOFIJO;
	private static Double CONSUMOMAXIMO;
    private static Double CONSUMOMINIMO;
    
    public Double getCargoVariable() {
        return CARGOVARIABLE;
    }
    
    public Double getCargoFijo() {
    	return CARGOFIJO;
    }
    
    public Boolean pertenece(Double consumo){
    	return ((CONSUMOMINIMO < consumo) && (consumo <= CONSUMOMAXIMO));
    }

    public String getNombre(){ return null; }
    public CategoriaResidencial getCategoria(){return null;} //dudoso

    @JsonCreator
    public static CategoriaResidencial fromString(String tipoCategoria) {

       List<CategoriaResidencial> listaClases = asList(new CategoriaR1(),new CategoriaR2(),new CategoriaR2(),
                                                       new CategoriaR3(),new CategoriaR4(),new CategoriaR5(),
                                                       new CategoriaR6(),new CategoriaR7(),new CategoriaR8(),
                                                       new CategoriaR9());

        CategoriaResidencial categoria =  listaClases.stream()
                .filter(x -> tipoCategoria.equals(x.getNombre()))
                .findAny()
                .orElse(null);

      return categoria;
    }
}

  /*  CATEGORIAS:
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