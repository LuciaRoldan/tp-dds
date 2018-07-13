package testZona;

import dispositivo.DispositivoInteligente;
import org.junit.Before;
import org.junit.Test;
import testsCliente.ClasesParaTestearCliente;
import transformador.Transformador;
import usuario.Cliente;
import zona.Zona;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class testZona {

    ArrayList<Cliente> listaDeClientes;
    Cliente cliente;
    ArrayList<DispositivoInteligente> dispositivos;
    Zona zona = new Zona();
    Transformador transformador1 = new Transformador();
    Transformador transformador2 = new Transformador();


    @Before

    public void setUp() throws Exception {

        cliente = ClasesParaTestearCliente.clienteEstandar();
        dispositivos = ClasesParaTestearCliente.cincoDispositivos();
        cliente.setDispositivosInteligentes(dispositivos);
        transformador1.addCliente(cliente);
        transformador2.addCliente(cliente);
        zona.addTransformador(transformador1);
        zona.addTransformador(transformador2);

    }


    @Test
    public void testEnergiaSuministrada() {
        assertEquals(java.util.Optional.of(500L), zona.energiaSuministrada());
    }
}
