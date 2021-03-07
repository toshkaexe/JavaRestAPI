
package server.restfull.controller;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TimeZone;

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

import server.restfull.dao.UserDaoImpl;
import server.restfull.model.User;
import server.restfull.repo.UserRepo;

import org.apache.commons.logging.Log;

import org.apache.juli.logging.LogFactory;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.JSONObject;
import org.apache.commons.logging.Log;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class UserController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDaoImpl userService;

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {


		return "Hello";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		log.info("all user list");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable String id) {

		if (userService.getUserById(id) == (null)) {
			log.info(String.format("Sorry, but we do not have user with id=%s", id));
			return null;
		} else
			log.info(String.format("Please User id=%s", id));
			return userService.getUserById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users", produces = "application/json")
	public void addUser(@RequestBody User user) throws ParseException {

		userService.addUser(user);
		log.info(String.format("putted the new  user with id=%s, USER[%s, name=%s, secondName=%s, email=%s]",
				user.getId(), user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()));

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}", produces = "application/json")
	public void deleteById(@PathVariable String id) {
		userService.deleteUser(id);
		log.info(String.format("Attention, we has deleted user with id=%s", id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}", produces = "application/json")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		userService.updateUser(id, user);
		log.info(String.format("updated the new  user with id=%s, USER[%s, name=%s, secondName=%s, email=%s]",
				user.getId(), user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()));
	}

}
