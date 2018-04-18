package categorias;

//R4 400<C<=450 cargo fijo = 71,74 cargo variable 0,738

public class CategoriaR4 implements CategoriaResidencial {

    @Override
    public Double cargoVariable() { return 0.738;}

    @Override
    public Double cargoFijo() { return 71.74; }

    @Override
    public Boolean pertenece(double consumo) {return ((400 < consumo) && (consumo <= 450)); }
}
