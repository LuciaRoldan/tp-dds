package categorias;// R6 500<C<=600 CARGO FIJO =220,75 // CARGO VARIABLE = 0,832


public class CategoriaR6 implements CategoriaResidencial {

    @Override
    public Double cargoVariable() { return 0.832; }

    @Override
    public Double cargoFijo() {return 220.75; }

    @Override
    public Boolean pertenece(double consumo) { return  ((500 < consumo) && (consumo <= 600));}
}
