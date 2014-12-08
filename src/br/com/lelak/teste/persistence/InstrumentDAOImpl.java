package br.com.lelak.teste.persistence;

import javax.persistence.EntityManager;

public class InstrumentDAOImpl extends GenericDAO {

	public InstrumentDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
