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
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return true;
        }
        return false;
    }

    public User updateUser(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    public boolean userExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean userExists(Long id) {
        return userRepository.findById(id).isPresent();
    }

    public boolean userExists(UserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail()).isPresent();
    }

    public boolean userExists(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getEmail().equals(userDto.getEmail());
        }
        return false;
    }

    public boolean passwordMatches(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(userDto.getPassword(), user.getPassword());
        }
        return false;
    }

    public boolean passwordMatches(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(userDto.getPassword(), user.getPassword());
        }
        return false;
    }

       public boolean passwordMatches(String email, UserDto userDto) {
           Optional<User> optionalUser = userRepository.findByEmail(email);
           if (optionalUser.isPresent()) {
               User user = optionalUser.get();
               return passwordEncoder.matches(userDto.getPassword(), user.getPassword());
           }
           return false;

       }
}
