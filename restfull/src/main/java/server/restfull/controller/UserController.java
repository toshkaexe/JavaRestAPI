

package server.restfull.controller;

import java.util.List;
import server.restfull.model.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import server.restfull.model.User;
import server.restfull.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
	private UserService userService;

    @RequestMapping("users")
    public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
    @RequestMapping("uuu")
    public void ttt() {
    	
    	System.out.println("AAAAAAAAAAAAAAA");
    }
    
    
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        System.out.println("ID is " + id);
        
        if ( userService.getUserById(id) == (null))
        {
        	System.out.println(String.format("We do not have user with id=%s",id));
        	return null;
        }
        else  return userService.getUserById(id);
      //  return "Dynamic URI parameter fetched";
    }
    


	@RequestMapping(method=RequestMethod.POST, value ="users")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id)
	{
		userService.updateUserList(id,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="users/{id}")
	public void deleteUser(@RequestBody User user, @PathVariable int id)
	{
		userService.deleteUserList(id);
	 	System.out.println("AAAAAAAAAAAAAAABBBBBBBBBBBBBB");
	}
	
		
	
}

