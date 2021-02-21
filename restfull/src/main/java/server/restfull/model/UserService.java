package server.restfull.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

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
public class UserService {

	private List<User> users = new ArrayList<>();

	public UserService() throws org.json.simple.parser.ParseException {
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

				System.out.println(String.format("item = %d, %s, - %s - %s, - %s", i, userItem.get("id"), userItem.get("name"),
						userItem.get("lastname"), userItem.get("email")));

				users.add(new User(userItem.get("id").toString(), userItem.get("name").toString(),
						userItem.get("lastname").toString(), userItem.get("email").toString()));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<User> getAllUsers() {

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

	public void addUser(User user) {
		users.add(user);

	}

	public void updateUserList(int id, User user) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if ((u.getId()).equals(id))

			{
				users.set(id, user);
				return;

			}

		}
	}

	public User getUserwithId(int id) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id))

				return u;

		}
		return null;
	}

	public void deleteUserList(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.remove(id);
				return;

			}

		}

	}

}
