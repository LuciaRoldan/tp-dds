package categorias;

import static java.util.Arrays.asList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

public enum CategoriaResidencial {

	CATEGORIAR1("CATEGORIA1", 0.644, 18.76, 150.00, 0.00), CATEGORIAR2("CATEGORIA2", 0.644, 35.32, 325.00,
			150.00), CATEGORIAR3("CATEGORIA3", 0.681, 60.71, 400.00, 325.00), CATEGORIAR4("CATEGORIA4", 0.738, 71.74,
					450.00, 400.00), CATEGORIAR5("CATEGORIA5", 0.794, 110.38, 500.00, 450.00), CATEGORIAR6("CATEGORIA6",
							0.832, 220.75, 600.00, 500.00), CATEGORIAR7("CATEGORIA7", 0.851, 443.59, 700.00,
									600.00), CATEGORIAR8("CATEGORIA8", 0.851, 545.96, 1400.00,
											700.00), CATEGORIAR9("CATEGORIA9", 0.851, 887.19, 10000000.00, 1400.00);

	private String nombre;
	private Double cargoVariable;
	private Double cargoFijo;
	private Double consumoMaximo;
	private Double consumoMinimo;

	private CategoriaResidencial(String nombre, Double cargoVariable, Double cargoFijo, Double consumoMaximo,
			Double consumoMinimo) {
		this.nombre = nombre;
		this.cargoVariable = cargoVariable;
		this.cargoFijo = cargoFijo;
		this.consumoMaximo = consumoMaximo;
		this.consumoMinimo = consumoMinimo;

	}

	public String getNombre() {
		return this.nombre;
	}

	public Double getCargoVariable() {
		return this.cargoVariable;
	}

	public Double getCargoFijo() {
		return this.cargoFijo;
	}

	public Boolean pertenece(Double consumo) {
		return ((this.consumoMinimo < consumo) && (consumo <= this.consumoMaximo));
	}

	public static List<CategoriaResidencial> listaClases = asList(CategoriaResidencial.CATEGORIAR1,
			CategoriaResidencial.CATEGORIAR2, CategoriaResidencial.CATEGORIAR3, CategoriaResidencial.CATEGORIAR4,
			CategoriaResidencial.CATEGORIAR5, CategoriaResidencial.CATEGORIAR6, CategoriaResidencial.CATEGORIAR7,
			CategoriaResidencial.CATEGORIAR8, CategoriaResidencial.CATEGORIAR9);

	public CategoriaResidencial recategorizar(Double consumo) {
		return listaClases.stream().filter(categoria -> categoria.pertenece(consumo)).findFirst().get();
	}

	@JsonCreator
	public static CategoriaResidencial fromString(String tipoCategoria) {

		CategoriaResidencial categoria = listaClases.stream().filter(x -> tipoCategoria.equals(x.getNombre()))
				.findAny().orElse(null);

		return categoria;
	}
}
