package server.restfull.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import server.restfull.model.User;

public class UserDaoTest {

	private UserDao dao;

	@Before
	public void setUp() throws Exception {
		this.dao = new UserDaoImpl();
	}

	@Test
	public void TEST_getUserById() throws Exception {

		User extectedUser = new User("187", "Donald", "Tramp", "Donald.trump@gmail.com");
		User actual = dao.getUserById("187");

		assertEquals(extectedUser.getFirstName(), actual.getFirstName());
		assertEquals(extectedUser.getLastName(), actual.getLastName());
		assertEquals(extectedUser.getEmail(), actual.getEmail());
	}

	@Test
	public void TEST_addUser() throws Exception {

		UserDao dao = new UserDaoImpl();
		User newUser = new User("18717", "Pavel", "Durov", "Pavel.Durov@gmail.com");
		String expectedName = newUser.getFirstName();
		String expectedLastName = newUser.getLastName();
		String expectedEmail = newUser.getEmail();

		String expectedID = newUser.getId();
		// addUser
		dao.addUser(newUser);

		assertEquals(expectedName, dao.getUserById(expectedID).getFirstName());
		assertEquals(expectedLastName, dao.getUserById(expectedID).getLastName());
		assertEquals(expectedEmail, dao.getUserById(expectedID).getEmail());

	}

	@Test
	public void TEST_deleteUser() throws Exception {

		UserDao dao = new UserDaoImpl();
		User newUser = new User("187", "Pavel", "Durov", "Pavel.Durov@gmail.com");
		String expectedName = newUser.getFirstName();
		String expectedLastName = newUser.getLastName();
		String expectedEmail = newUser.getEmail();

		String expectedID = newUser.getId();
		// addUser
		dao.deleteUser("187");
		User actual1 = dao.getUserById("187");

		assertEquals(null, dao.getUserById("187"));

	}

}

//List<User> users = new ArrayList<User>();
//users.add(new User("Tam", "Wind", "Tam.Wind@gmail.com", "1"));
//users.add(new User("Till", "Ramm", "Till.Ramm@gmail.com", "2"));
//users.add(new User("Tom", "Baum", "tom.baum@gmail.com", "3"));
//users.add(new User("Thomas", "Mueller", "mueller@gmail.com", "4"));
