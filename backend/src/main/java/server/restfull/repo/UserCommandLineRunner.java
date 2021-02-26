package server.restfull.repo;

import org.springframework.boot.CommandLineRunner;

public class UserCommandLineRunner implements CommandLineRunner {

	private UserRepo userRepository;

	public UserCommandLineRunner(UserRepo userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		userRepository.findAll().forEach(System.out::println);

	}

}
