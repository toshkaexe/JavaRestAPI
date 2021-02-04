package server.restfull.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.restfull.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
