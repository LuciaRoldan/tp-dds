//R3 325<C<=400 cargo fijo = 60,71 cargo variable = 0,681

public class CategoriaR3 implements CategoriaResidencial{

    @Override
    public double cargoVariable() {return 0.681;}

    @Override
    public double cargoFijo() { return 60.71; }

    @Override
    public boolean pertenece(double consumo) {return ((325 < consumo) && (consumo <= 400));}

}
