package server.restfull.model;

import java.util.List;

public interface UserDao {

	void addUser(User newUser);

	void deleteUser(String id);

	User getUserById(String id);

	List<User> getAllUsers();

}
