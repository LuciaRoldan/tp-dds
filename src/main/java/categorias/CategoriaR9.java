package categorias;


// R9 C>1400 CARGO FIJO = 887,19 // CARGO VARIABLE = 0,851

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")

public class CategoriaR9 extends CategoriaResidencial {

    @JsonTypeId
    public CategoriaR9 categoriaR9;

    @Override
    public Double cargoVariable() {return 0.851; }

    @Override
    public Double cargoFijo(){return 887.19;}

    @Override
    public Boolean pertenece(double consumo) {return (consumo >1400);}

    public String getNombre(){return "CategoriaR9";}

    @JsonCreator
    public  CategoriaR9 CategoriaR9(){
        System.out.print("JsonCreator");
        return this;
    }


}
