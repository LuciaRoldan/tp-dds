package dataBase;

import dispositivosConcretos.DispositivoConcreto;
import sensor.Sensor;
import transformador.Transformador;
import usuario.Administrador;
import usuario.Cliente;
import zona.Zona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DataBase {

    private static DataBase instance = null;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void persistirCliente(Cliente cliente){
       this.persistir(cliente);
    }

    public void persistirAdministrador(Administrador admin){
        this.persistir(admin);
    }


    public void persistirSensor(Sensor sensor){
        this.persistir(sensor);
    }

    public void persistirTransformador(Transformador transformador){
        this.persistir(transformador);
    }

    private void persistir(Object x){
        entityManager.getTransaction().begin();
        entityManager.persist(x);
        entityManager.getTransaction().commit();
    }

    /////////////////////////////////////////// SINGLETON /////////////////////////////////////////////////

    private DataBase(){}

    public static DataBase getInstance() {
        if (instance == null){
            synchronized(DataBase.class)
            {
                if(instance==null){
                    instance=new DataBase();
                }
            }
        }
            return instance;
    }

    public void persistirUnaZona(Zona zona) {
        this.persistir(zona);
    }

    public Zona getZona(Integer id) {
        return entityManager.find(Zona.class,id );
    }
    public Cliente getCliente(Integer id){
        return entityManager.find(Cliente.class,id );
    }

    public Transformador getTransformador(Integer id) {
        return entityManager.find(Transformador.class,id );
    }

    public Sensor getSensor(Integer id) {
        return entityManager.find(Sensor.class,id );
    }

    public DispositivoConcreto getDispositivo(Integer id) {
            return entityManager.find(DispositivoConcreto.class,id );
    }
}
