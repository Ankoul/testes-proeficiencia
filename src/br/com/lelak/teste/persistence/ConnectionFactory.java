package br.com.lelak.teste.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static final String PERSISTENCE_UNIT = "lelakPersistenceUnit";
	private static EntityManager entityManager;

	public static EntityManager getEntityManager(){
		if(entityManager == null){
			entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
		}
		return entityManager;
	}
	
}
