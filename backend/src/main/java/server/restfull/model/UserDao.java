package server.restfull.model;

import java.util.List;

public interface UserDao {

	void addUser(User newUser);

	List<User> deleteUser(String id);

	User getUserById(String id);

	List<User> getAllUsers();

	void update(User user);

}
