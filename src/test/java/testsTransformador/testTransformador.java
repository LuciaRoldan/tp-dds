package testsTransformador;

import dispositivo.DispositivoInteligente;
import mock.ClienteMock;
import org.junit.Before;
import org.junit.Test;
import testsCliente.ClasesParaTestearCliente;
import transformador.Transformador;
import usuario.Cliente;
import zona.Zona;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class testTransformador {

    ArrayList<Cliente> listaDeClientes;
    ClienteMock cliente;
    ArrayList<DispositivoInteligente> dispositivos;
    Zona zona = new Zona();
    Transformador transformador1 = new Transformador();
    Transformador transformador2 = new Transformador();


    @Before

    public void setUp() throws Exception {

        cliente = new ClienteMock();
        transformador1.addCliente(cliente);

    }


    @Test
    public void testConsumo1Cliente() {
        assertEquals(200L, java.util.Optional.ofNullable(transformador1.energiaSuministrada()));
    }

    @Test
    public void testConsumo2Cliente() {
        transformador1.addCliente(cliente);
        assertEquals(400L, java.util.Optional.ofNullable(transformador1.energiaSuministrada()));
    }

    @Test
    public void testConsumo0Clientes() {
        assertEquals(java.util.Optional.of(0), transformador2.energiaSuministrada());
    }
}
