package server.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import server.restfull.model.User;
import server.restfull.repo.UserRepo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		DemoApplication.class.getResourceAsStream("/userlist.json");
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {

		// this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
		// this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
		// this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));

		// this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
		// this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
		// this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));
		/***
		 * JSONParser parser = new JSONParser(); JSONArray jsonArray; try { jsonArray =
		 * (JSONArray) parser.parse(new FileReader("data/userlist.json")); for (Object
		 * jsonItem : jsonArray) { JSONObject jsonObject = (JSONObject) jsonItem; String
		 * lastName = (String) jsonObject.get("lastName"); String firstName = (String)
		 * jsonObject.get("firstName"); String email = (String) jsonObject.get("email");
		 * this.userRepository.save(new User(lastName, firstName, email)); } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (org.json.simple.parser.ParseException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 */

	}

}
