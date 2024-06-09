package se.dsve.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dsve.notes.dtos.LoginUserDto;
import se.dsve.notes.dtos.RegisterUserDto;
import se.dsve.notes.dtos.UserDto;
import se.dsve.notes.model.LoginResponse;
import se.dsve.notes.model.User;
import se.dsve.notes.service.AuthenticationService;
import se.dsve.notes.service.JwtService;
import se.dsve.notes.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    // TODO: Implement AuthenticationController
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        // TODO: Implement register, the method declaration should not be changed!!!
        if (!isValidEmail(registerUserDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        User user = new User();
        user.setFullName(registerUserDto.getFullName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());

        // Convert User to UserDto
        UserDto userDto = UserDto.fromUser(user);

        // Register the user
        UserDto registeredUser = userService.registerUser(userDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
        // Authenticate the user
        User user = authenticationService.authenticate(loginUserDto.getEmail(), loginUserDto.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Generate the JWT token
        String token = authenticationService.generateToken(user);

        // Create the LoginResponse object
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        return ResponseEntity.ok(loginResponse);
    }
    private boolean isValidEmail(String email) {
        // Simple email validation regex pattern
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailPattern);
    }
}
