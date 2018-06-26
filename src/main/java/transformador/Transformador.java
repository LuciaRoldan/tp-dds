package transformador;

import usuario.Cliente;
import zona.Zona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transformador {


    ////////////////////////////////// ATRIBUTOS ///////////////////////////////////////////
    private Float coordenadaX;
    private Float coordenadaY;
    private Zona  zona;
    private String nombre;
    private List<Cliente> listaDeClientes = new ArrayList<Cliente>();

    ///////////////////////////////// METODOS ///////////////////////////////////////////////


    public Long energiaSuministrada(){
        return   listaDeClientes.stream().mapToLong(cliente -> cliente.calcularConsumoAhora()).sum();
    }

}
