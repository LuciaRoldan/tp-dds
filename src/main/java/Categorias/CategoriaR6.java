package Categorias;

// R6 500<C<=600 CARGO FIJO =220,75 // CARGO VARIABLE = 0,832


public class CategoriaR6 implements CategoriaResidencial{

    @Override
    public double cargoVariable() { return 0.832; }

    @Override
    public double cargoFijo() {return 220.75; }

    @Override
    public boolean pertenece(double consumo) { return  ((500 < consumo) && (consumo <= 600));}
}
