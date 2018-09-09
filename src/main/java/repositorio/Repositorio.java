package repositorio;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public abstract class Repositorio {

	EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	public EntityManager obtenerEntityManager() {
		return entityManager;
	}

}
