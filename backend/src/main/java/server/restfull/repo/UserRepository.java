package server.restfull.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.restfull.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {



}