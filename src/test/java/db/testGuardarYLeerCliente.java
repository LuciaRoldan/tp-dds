package db;

import dataBase.DataBase;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sensor.Sensor;
import transformador.Transformador;
import usuario.Cliente;
import zona.Zona;

import static org.junit.Assert.assertEquals;

public class testGuardarYLeerCliente {

    Cliente       cliente           = new ClaseParaDB().getCliente();
    DataBase      db2               = DataBase.getInstance();
    Sensor        sensor            = new ClaseParaDB().getSensor();
    Transformador transformador     = new ClaseParaDB().getTransformador();
    Zona          zona              = new ClaseParaDB().getZona();
    Cliente       cliente2;
    Sensor        sensor2;
    Transformador transformador2;
    Zona          zona2;





    @Test
    public void guardarYleerUnCliente() {
        System.out.println(cliente.nombreDeUsuario);
        db2.persistirCliente(cliente);
        Integer id = cliente.getId();
        System.out.println(id);
        cliente2 = db2.getCliente(id);
        assertEquals(cliente2,cliente);
    }

    @Test
    public void guardarYleerUnaZona() {
        System.out.println(zona.getCoordenadaX());
        db2.persistirUnaZona(zona);
        Integer id = zona.getNumeroDeZona();
        System.out.println(id);
        zona2 = db2.getZona(id);
        System.out.println(zona2.getNumeroDeZona());
    }


    @Test
    public void guardarYleerUnTransformador() {
        db2.persistirTransformador(transformador);
        Integer id = transformador.getNumeroDeTransformador();
        System.out.println(id);
        transformador2 = db2.getTransformador(id);
        System.out.println(transformador2.getNumeroDeTransformador());
    }



    @Test
    public void guardarYleerUnSensor() {
        db2.persistirSensor(sensor);
        Integer id = sensor.getNumeroDeSensor();
        System.out.println(id);
        sensor2 = db2.getSensor(id);
        assertEquals(sensor2,sensor);
    }



}
