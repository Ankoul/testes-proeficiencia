package br.com.lelak.teste.persistence;

import java.lang.reflect.Constructor;

import javax.persistence.EntityManager;

abstract public class DAOFactory<R> {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <R> R  createDAO(Class<R> entityBeanClass) throws ReflectiveOperationException  {
        String filenameDAO = entityBeanClass.getName() + "Impl";               
        Class classDAO = Class.forName(filenameDAO);
		Constructor constructor = classDAO.getConstructor(EntityManager.class);
		return (R) constructor.newInstance(ConnectionFactory.getEntityManager());
    }
}
