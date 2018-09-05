package dataBase;






import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hsqldb.Session;
import org.hsqldb.SessionManager;
import sensor.Sensor;
import transformador.Transformador;
import usuario.Administrador;
import usuario.Cliente;
import usuario.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DataBase {

    private static DataBase instance = null;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void persistirCliente(Cliente cliente){
       this.persistir(cliente);
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

    public void persistirAdministrador(Administrador administrador){

    }
}
