//R5 450<C<500 cargo fijo 110,38 cargo variable 0,794


public class CategoriaR5 implements CategoriaResidencial{

    public double cargoVariable() {
        return 0.794;
    }

    @Override
    public double cargoFijo() {
        return 110.38;
    }

    @Override
    public boolean pertenece(double consumo) {return ((450 < consumo) && (consumo <= 500));}
}
