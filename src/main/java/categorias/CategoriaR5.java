package categorias;//R5 450<C<500 cargo fijo 110,38 cargo variable 0,794


public class CategoriaR5 implements CategoriaResidencial {

    public Double cargoVariable() {
        return 0.794;
    }

    @Override
    public Double cargoFijo() {
        return 110.38;
    }

    @Override
    public Boolean pertenece(double consumo) {return ((450 < consumo) && (consumo <= 500));}
}
