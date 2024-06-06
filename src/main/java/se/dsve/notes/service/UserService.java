package se.dsve.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.dsve.notes.dtos.UserDto;
import se.dsve.notes.model.User;
import se.dsve.notes.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    // TODO: Implement UserService
}
