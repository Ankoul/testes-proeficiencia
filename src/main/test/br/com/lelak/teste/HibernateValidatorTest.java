package br.com.lelak.teste;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lelak.teste.model.User;

public class HibernateValidatorTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void userMustBeValid() {
		User user = getUserForTest();

		assertEquals(0, validate(user));
	}

	@Test
	public void nameUserCantBeNullOrEmpty() {

		User user = getUserForTest();

		user.setName(null);
		assertEquals(1, validate(user));

		user.setName("");
		assertEquals(1, validate(user));
	}

	@Test
	public void lastNameUserCanAcceptNullOrEmpty() {

		User user = getUserForTest();

		user.setLastName(null);
		assertEquals(0, validate(user));

		user.setLastName("");
		assertEquals(0, validate(user));
	}

	@Test
	public void emailCantBeInvalid() {

		User user = getUserForTest();

		user.setEmail(null);
		assertEquals(1, validate(user));

		user.setEmail("");
		assertEquals(1, validate(user));

		user.setEmail("gilson");
		assertEquals(1, validate(user));

	}

	@Test
	public void emailMustAcceptValid() {

		User user = getUserForTest();

		user.setEmail("12345@192.168.1.1");
		assertEquals(0, validate(user));

		user.setEmail("gilson@192.168.1.1");
		assertEquals(0, validate(user));

		user.setEmail("gilson@email.com.br.br.br.br.br");
		assertEquals(0, validate(user));

		user.setEmail("gilson@email");
		assertEquals(0, validate(user));
	}

	@Test
	public void phoneLengthCantBeGreaterThan14() {
		User user = getUserForTest();

		user.setPhone("123456789012345");
		assertEquals(1, validate(user));
	}
	
	@Test
	public void phoneLengthCantBeLessThan12() {
		User user = getUserForTest();
		
		user.setPhone("12345678901");
		assertEquals(1, validate(user));
	}

	private User getUserForTest() {
		return new User(null, "FirstName", "LastName", "gilson@email.com", "(12)123456789");
	}

	private int validate(User user) {
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		printMessages(constraintViolations);
		return constraintViolations.size();
	}

	private void printMessages(Set<ConstraintViolation<User>> constraintViolations) {
		Iterator<ConstraintViolation<User>> iterator = constraintViolations.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getMessage());
		}
	}

}
