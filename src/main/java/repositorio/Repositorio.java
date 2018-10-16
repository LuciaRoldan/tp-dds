package repositorio;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public abstract class Repositorio {

	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	public EntityManager obtenerEntityManager() {
		return entityManager;
	}

	protected void persistir(Object x){
        entityManager.getTransaction().begin();
        entityManager.persist(x);
        entityManager.getTransaction().commit();
    }
}
