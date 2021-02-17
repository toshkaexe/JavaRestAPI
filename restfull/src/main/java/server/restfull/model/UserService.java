package server.restfull.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	private List <User>  users = new ArrayList<>(Arrays.asList(
			new User("1", "Anton", "Zzz", "anton.zzz@gmail.com"),
			new User("2", "Boni", "Noro","boni.noro@com.com"),
			new User("3", "Tino", "Bach", "bach@p2.com")
			));
	
	
	public List<User> getAllUsers() {
		
		return users;
	}
	
	
	public User getUserById(String id)
	{
		
		for(int i=0; i<users.size(); i++) {
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
	
	public void updateUserList(int id, User user)
	{
		for (int i = 0; i<users.size(); i++)
		 {
			User u = users.get(i);
				if ((u.getId()).equals(id))
						
						{        
			         users.set(id, user);	
			         return;
			         
					
		}
			
			}
	}
	

	
	
	public User getUserwithId(int id)
	{
		for (int i = 0; i<users.size(); i++)
		 {
			User u = users.get(i);
				if (u.getId().equals(id))
						
			         	
			         return u;
					
		
			
			}
		return null;
	}

	public void deleteUserList(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i<users.size(); i++)
		 {
			User u = users.get(i);
				if (u.getId().equals(id))
						{
			         users.remove(id);	
			         return;
					
		}
			
			}
		
	}




	
	
}

	