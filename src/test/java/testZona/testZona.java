package testZona;

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

public class testZona {

    ClienteMock cliente = new ClienteMock();
    ClienteMock cliente2 = new ClienteMock();
    Zona zona = new Zona();
    Zona zonaVacia = new Zona();
    Transformador transformador1 = new Transformador();
    Transformador transformador2 = new Transformador();


    @Before

    public void setUp() throws Exception {


        transformador1.addCliente(cliente);
        transformador1.addCliente(cliente2);
        transformador2.addCliente(cliente);
        transformador2.addCliente(cliente2);
        zona.addTransformador(transformador1);
        zona.addTransformador(transformador2);

    }


    @Test
    public void testEnergiaSuministrada() {
        assertEquals(java.util.Optional.of(800L), zona.energiaSuministrada());
    }
    
    @Test
    public void testZonaVacia(){
        assertEquals(java.util.Optional.of(0),zonaVacia.energiaSuministrada());
    }
}
