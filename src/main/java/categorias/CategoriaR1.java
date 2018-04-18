package categorias;// R1 C<= 150 ; Cargo fijo = 18,76 Cargo variable = 0,644

public class CategoriaR1 implements CategoriaResidencial {

    @Override
    public Double cargoVariable() { return 0.644; }

    @Override
    public Double cargoFijo() { return 18.76;}

    @Override
    public Boolean pertenece(double consumo) { return (consumo <= 150);}
}
