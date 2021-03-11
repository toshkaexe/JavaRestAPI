package server.restfull.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import server.restfull.model.User;
import server.restfull.service.UserService;

public class UserDaoTest {

	private UserDao dao;

	@Before
	public void setUp() throws Exception {
		this.dao = new UserService();
	}

	@Test
	public void TEST_getUserById() throws Exception {

		User extectedUser = new User("1", "Anton", "Mueller", "anton.Mueller@gogole.de");
		User actual = dao.getUserById("1");

		assertEquals(extectedUser.getFirstName(), actual.getFirstName());
		assertEquals(extectedUser.getLastName(), actual.getLastName());
		assertEquals(extectedUser.getEmail(), actual.getEmail());

	}

	@Test
	public void TEST_deleteUser() throws Exception {

		UserDao dao = new UserService();
		dao.deleteUser("1");
		assertEquals(null, dao.getUserById("1"));

	}

	@Test
	public void TEST_addUser() throws Exception {

		User newUser = new User("10", "Peter", "Bach", "Peter.Bach@gogole.de");
		dao.addUser(newUser);

		User newUserWithFromList = dao.getUserById("10");

		assertEquals(newUser.getFirstName(), newUserWithFromList.getFirstName());
		assertEquals(newUser.getLastName(), newUserWithFromList.getLastName());
		assertEquals(newUser.getEmail(), newUserWithFromList.getEmail());

	}

}

//List<User> users = new ArrayList<User>();
//users.add(new User("Tam", "Wind", "Tam.Wind@gmail.com", "1"));
//users.add(new User("Till", "Ramm", "Till.Ramm@gmail.com", "2"));
//users.add(new User("Tom", "Baum", "tom.baum@gmail.com", "3"));
//users.add(new User("Thomas", "Mueller", "mueller@gmail.com", "4"));
