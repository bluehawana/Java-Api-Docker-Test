package se.dsve.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dsve.notes.model.User;

import java.util.Optional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
