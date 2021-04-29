package server.restfull.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.restfull.model.UserDao;
import server.restfull.repo.UserRepository;
import server.restfull.model.User;

import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService implements UserDao {
	Logger log = LoggerFactory.getLogger(getClass());

	private List<User> users = new ArrayList<>();

	public UserService() throws org.json.simple.parser.ParseException {

		this.users.add(new User("1", "Anton", "Mueller", "anton.Mueller@gogole.de"));
		this.users.add(new User("3", "Tao", "Mao", "Tao.Mao@gogole.de"));
		this.users.add(new User("5", "Max", "Bauer", "Max.Bauer@gogole.de"));
	}

	public List<User> findAll() {

		return users;
	}

	public User getUserById(String id) {

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if ((u.getId()).equals(id)) {
				return users.get(i);
			}
		}

		log.error(String.format("Status: 404: We do not find User by id=%s, USER[id=%s]", id, id));
		return new User("--", "--", "--", "--");
	}

	public void deleteUser(String id) {

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.remove(i);

			}

		}

	}

	public void addUser(User user) {
		users.add(user);
		System.out.println(user.toString());

	}

	@Override
	public List<User> getAllUsers() {

		return users;
	}

	public void updateUser(String id, User user) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.set(i, user);
				return;
			}

		}

	}

}
