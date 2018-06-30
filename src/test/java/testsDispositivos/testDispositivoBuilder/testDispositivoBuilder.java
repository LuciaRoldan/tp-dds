package testsDispositivos.testDispositivoBuilder;

import dispositivo.DispositivoBuilder;
import dispositivo.DispositivoEstandar;
import dispositivo.DispositivoInteligenteInterfaz;
import dispositivo.DispositivoInteligente;
import dispositivo.estados.Apagado;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class testDispositivoBuilder {


    @Before

    public void setUp() throws Exception {

        DispositivoInteligenteInterfaz dispositivoInteligente = new DispositivoInteligente("Microondas",new Apagado(),20L);
        DispositivoEstandar dispositivoEstandar = new DispositivoEstandar(10L,"Termotanque",5L);
    }


    @Test
    public void testConstruirDispositivoEstandar() {

    DispositivoBuilder builder = new DispositivoBuilder();
    builder.setConsumoHora(20L);
    builder.setName("Calefon");
    builder.setHorasUsoDia(10L);
    DispositivoEstandar dispositivoEstandar = builder.construirEstandar();

    assertEquals("Calefon", dispositivoEstandar.getName());
    assertEquals(Long.valueOf(20), dispositivoEstandar.getConsumoPorHora());
    assertEquals(Long.valueOf(10), dispositivoEstandar.getHorasDeUsoPorDia());

    }

    @Test
    public void testConstruirDispositivoInteligente() {

        DispositivoBuilder builder = new DispositivoBuilder();
        builder.setConsumoHora(20L);
        builder.setName("Calefon");
        builder.setHorasUsoDia(10L);
        builder.setEstadoInicial(new Apagado());
        DispositivoInteligenteInterfaz dispositivoInteligente = builder.construirInteligente();

        assertEquals("Calefon", dispositivoInteligente.getName());
        assertEquals(Long.valueOf(20), dispositivoInteligente.getkWh());
    }

    public void testConstruirDispositivoInteligenteModuloEstandar() {

        DispositivoBuilder builder = new DispositivoBuilder();
        builder.setConsumoHora(20L);
        builder.setName("Calefon");
        builder.setHorasUsoDia(10L);
        builder.setEstadoInicial(new Apagado());
        builder.agregarModulo();
        DispositivoInteligenteInterfaz dispositivoInteligente = builder.construirInteligente();

        assertEquals("Calefon", dispositivoInteligente.getName());
        assertEquals(Long.valueOf(20), dispositivoInteligente.getkWh());
    }

}