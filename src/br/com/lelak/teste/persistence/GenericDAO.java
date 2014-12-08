package br.com.lelak.teste.persistence;

import javax.persistence.EntityManager;

abstract public class GenericDAO implements DAO {
	
	protected EntityManager entityManager;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
