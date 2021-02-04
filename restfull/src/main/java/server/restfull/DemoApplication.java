package server.restfull;

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
		this.userRepository.save(new User("Ramesh", "Fadatare", "ramesh@gmail.com"));
		this.userRepository.save(new User("Tom", "Cruise", "tom@gmail.com"));
		this.userRepository.save(new User("Tony", "Stark", "tony@gmail.com"));
	}
}
