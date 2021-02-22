package server.restfull.dao;

import java.util.List;

import server.restfull.model.User;

public interface UserDao {

	void addUser();

	User getUserById(String id);

	List<User> getAllUsers();

	void update(User user);

	void delete(int id);

	User getUserById(int id);

}
