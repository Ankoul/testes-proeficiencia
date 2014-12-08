package br.com.lelak.teste.persistence;

import javax.persistence.EntityManager;

public class UserDAOImpl extends GenericDAO implements UserDAO {

	public UserDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	

}
