package Categorias;



//R8 700<C<= 1400 cargo fijo 545,96 cargo variable 0,851



public class CategoriaR8 implements CategoriaResidencial{

    @Override
    public double cargoVariable() {
        return 0.851;
    }

    @Override
    public double cargoFijo() { return 545.96; }

    @Override
    public boolean pertenece(double consumo) { return ((700 < consumo) && (consumo <= 1400));}
}
