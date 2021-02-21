
package server.restfull.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import server.restfull.model.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.log.LogFormatUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import server.restfull.model.User;
import server.restfull.repo.UserRepo;
import org.apache.commons.logging.Log;

import org.apache.juli.logging.LogFactory;
import org.json.JSONObject;
import org.json.JSONObject;
import org.apache.commons.logging.Log;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {

		return "login";
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable String id) {
		System.out.println("ID is " + id);

		if (userService.getUserById(id) == (null)) {
			System.out.println(String.format("Sorry, but we do not have user with id=%s", id));
			return null;
		} else
			return userService.getUserById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "users")
	public void addUser(@RequestBody User user) {
		userService.addUser(new User("11", "Mana", "Papa", "Pap@gail.com"));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "users/{id}", produces = "application/json")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		userService.updateUserList(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "users/{id}")
	public void deleteUser(@RequestBody User user, @PathVariable int id) {
		userService.deleteUserList(id);
		System.out.println("AAAAAAAAAAAAAAABBBBBBBBBBBBBB");
	}

}
