package Categorias;



//R4 400<C<=450 cargo fijo = 71,74 cargo variable 0,738

public class CategoriaR4 implements CategoriaResidencial{

    @Override
    public double cargoVariable() { return 0.738;}

    @Override
    public double cargoFijo() { return 71.74; }

    @Override
    public boolean pertenece(double consumo) {return ((400 < consumo) && (consumo <= 450)); }
}
