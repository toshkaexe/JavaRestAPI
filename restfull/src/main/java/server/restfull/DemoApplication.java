package server.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import server.restfull.model.User;
import server.restfull.repo.UserRepo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.restfull.model.User;
import server.restfull.repo.UserRepo;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserRepo userRepository;

	public void run(String... args) throws Exception {
	//	this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
	//	this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
	//	this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));
		
		
	//  this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
		  // this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
		  // this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));
		  JSONParser parser = new JSONParser();
		  JSONArray jsonArray;
		  try {
		   jsonArray = (JSONArray) parser.parse(new FileReader("data/userlist.json"));
		   for (Object jsonItem : jsonArray) {
		    JSONObject jsonObject = (JSONObject) jsonItem;
		     String lastName = (String) jsonObject.get("lastName");
		     String firstName = (String) jsonObject.get("firstName");
		     String email = (String) jsonObject.get("email");
		     this.userRepository.save(new User(lastName, firstName, email));
		   }
		  } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (org.json.simple.parser.ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}
}
