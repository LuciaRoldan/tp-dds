package testZona;

import mock.ClienteMock;

import org.junit.Before;
import org.junit.Test;

import transformador.Transformador;
import zona.Zona;

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
        assertEquals(Long.valueOf(800), zona.energiaSuministrada());
    }
    
    @Test
    public void testZonaVacia(){
        assertEquals(Long.valueOf(0),zonaVacia.energiaSuministrada());
    }
}
