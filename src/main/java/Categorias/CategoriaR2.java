package Categorias;



// R2 150 < C <= 325 cargo fijo = 35,32  cargo variable = 0,644


public class CategoriaR2 implements CategoriaResidencial{
    public double cargoVariable() { return 0.644; }

    @Override
    public double cargoFijo() { return 35.32;}

    @Override
    public boolean pertenece(double consumo) { return ((150 < consumo) && (consumo <= 325)); }
}
