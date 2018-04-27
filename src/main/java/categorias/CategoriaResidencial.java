package categorias;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;
import static java.util.Arrays.asList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({

		@JsonSubTypes.Type(value = CategoriaR9.class, name = "CategoriaR9"),

})

public abstract class CategoriaResidencial {

	public Double getCargoVariable() {
		return null;
	}

	public Double getCargoFijo() {
		return null;
	}

	public String getNombre() {
		return null;
	}

	public Boolean pertenece(Double consumo) {
		return null;
	}

	public static List<CategoriaResidencial> listaClases = asList(new CategoriaR1(), new CategoriaR2(),
			new CategoriaR2(), new CategoriaR3(), new CategoriaR4(), new CategoriaR5(), new CategoriaR6(),
			new CategoriaR7(), new CategoriaR8(), new CategoriaR9());

	public CategoriaResidencial recategorizar(Double consumo) {
		return listaClases.stream().filter(categoria -> categoria.pertenece(consumo))
								   .findFirst()
								   .get();
	}

	///// PARSER /////
	@JsonCreator
	public static CategoriaResidencial fromString(String tipoCategoria) {

		CategoriaResidencial categoria = listaClases.stream().filter(x -> tipoCategoria.equals(x.getNombre())).findAny()
				.orElse(null);

		return categoria;
	}
}
