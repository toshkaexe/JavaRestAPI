package server.restfull.dao;

import java.util.List;

import server.restfull.model.User;

public interface UserDao {

	List<User> addUser(User newUser);

	User getUserById(String id);

	List<User> getAllUsers();

	void update(User user);

	List<User> deleteById(String id);
	
	

}
