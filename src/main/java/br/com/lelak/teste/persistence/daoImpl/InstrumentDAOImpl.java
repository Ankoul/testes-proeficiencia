package br.com.lelak.teste.persistence.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.lelak.teste.entity.Instrument;
import br.com.lelak.teste.entity.User;
import br.com.lelak.teste.persistence.dao.InstrumentDAO;

class InstrumentDAOImpl extends DAOImpl<Instrument> implements InstrumentDAO {

	InstrumentDAOImpl(EntityManager entityManager) {
		super(Instrument.class, entityManager);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Instrument> listByUser(User user){
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT instrument FROM Instrument instrument ");
		sqlBuilder.append(" WHERE instrument.user.id = :id ");
		
		Query query = entityManager.createQuery(sqlBuilder.toString());
		query.setParameter("id", user.getId());
		
		return query.getResultList();
	}
	
	@Override
	public byte[] findImageById(Long id){
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT instrument.image FROM Instrument instrument ");
		sqlBuilder.append(" WHERE instrument.id = :id ");
		
		Query query = entityManager.createQuery(sqlBuilder.toString());
		query.setParameter("id", id);
		
		return (byte[]) query.getSingleResult();
	}

}
