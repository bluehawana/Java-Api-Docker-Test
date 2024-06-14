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

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(this::convertToUserDto);
    }

    public UserDto registerUser(User user) {
        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return convertToUserDto(savedUser);
    }

    private UserDto convertToUserDto(User user) {
        return UserDto.fromUser(user);
    }

    public List<UserDto> findAllUsers() {
        //converts all users to UserDto
        return userRepository.findAll().stream()
                .map(UserDto::fromUser)
                .collect(Collectors.toList());
    }
}