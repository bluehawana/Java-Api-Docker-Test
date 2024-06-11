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

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.map(this::convertToUserDto);
    }

    public UserDto registerUser(UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User savedUser = userRepository.save(user);
        return UserDto.fromUser(savedUser);
    }

    private UserDto convertToUserDto(User user) {
        return UserDto.fromUser(user);
    }
}