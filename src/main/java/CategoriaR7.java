//  R7 600<C<=700 cargo fijo 443,59 cargo variable 0,851

public class CategoriaR7 implements CategoriaResidencial{

    public double cargoVariable() { return 0.851; }
    public double cargoFijo() {return 443.59;}

    @Override
    public boolean pertenece(double consumo) {return ((600 < consumo) && (consumo <= 700));}



}
