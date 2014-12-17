package br.com.lelak.teste.util;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

abstract public class EntityValidator {
	
	public static <T> boolean isValid(T entity){
		Set<ConstraintViolation<T>> constraintViolations = getValidator().validate(entity);
		printMessages(constraintViolations);
		return constraintViolations.size() == 0;
	}

	private static javax.validation.Validator getValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		return validator;
	}
	
	private static <T> void printMessages(Set<ConstraintViolation<T>> constraintViolations) {
		Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getMessage());
		}
	}
	
}
