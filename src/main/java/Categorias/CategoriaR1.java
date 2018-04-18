package Categorias;

// R1 C<= 150 ; Cargo fijo = 18,76 Cargo variable = 0,644

public class CategoriaR1 implements CategoriaResidencial{

    @Override
    public double cargoVariable() { return 0.644; }

    @Override
    public double cargoFijo() { return 18.76;}

    @Override
    public boolean pertenece(double consumo) { return (consumo <= 150);}
}
