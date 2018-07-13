package testsTransformador;

import dispositivo.DispositivoInteligente;
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
    Cliente cliente;
    ArrayList<DispositivoInteligente> dispositivos;
    Zona zona = new Zona();
    Transformador transformador1 = new Transformador();


    @Before

    public void setUp() throws Exception {

        cliente = ClasesParaTestearCliente.clienteEstandar();
        dispositivos = ClasesParaTestearCliente.cincoDispositivos();
        cliente.setDispositivosInteligentes(dispositivos);
        transformador1.addCliente(cliente);

    }


    @Test
    public void testConsumo1Cliente() {
        assertEquals(java.util.Optional.of(500L), transformador1.energiaSuministrada());
    }
}
