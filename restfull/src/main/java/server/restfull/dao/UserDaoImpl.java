package server.restfull.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;
import server.restfull.model.User;

import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

@Service
public class UserDaoImpl implements UserDao {

	private List<User> users = new ArrayList<>();

	public UserDaoImpl() throws org.json.simple.parser.ParseException {
		List<User> users = new ArrayList<>();
		users = loadDataFromJsonArray();
		this.users = users;

	}

	List<User> loadDataFromJsonArray() throws org.json.simple.parser.ParseException {
		List<User> users = new ArrayList<>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("../restfull/src/main/resources/userlist.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			// extracting data array from json string
			JSONArray usersArray = (JSONArray) jsonObject.get("users");
			for (int i = 0; i < usersArray.size(); i++) {
				JSONObject userItem = (JSONObject) usersArray.get(i);

				System.out.println(String.format("item = %d, %s, - %s - %s, - %s", i, userItem.get("id"),
						userItem.get("name"), userItem.get("lastname"), userItem.get("email")));

				users.add(new User(userItem.get("id").toString(), userItem.get("name").toString(),
						userItem.get("lastname").toString(), userItem.get("email").toString()));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
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
		return null;
	}

	
	public List<User> deleteUser(String id) {

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.remove(i);
				return users;

			}

		}
		return null;

	}
	
	
	
	public List<User> addUser(User user) {
		User user1 = new User();
		users.add(user1);
		System.out.println(user1.toString());
		return this.users;

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}



	@Override
	public List<User> getAllUsers() {

		return users;
	}



}
