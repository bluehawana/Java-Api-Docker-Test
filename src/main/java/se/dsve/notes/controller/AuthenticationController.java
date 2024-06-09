package se.dsve.notes.controller;

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
    private final JwtService jwtService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService, UserService userService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        // TODO: Implement register, the method declaration should not be changed!!!
        User user = authenticationService.register(registerUserDto);
        return ResponseEntity.ok(UserDto.fromUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
        // TODO: Implement authenticate, the method declaration should not be changed!!!
        User user = authenticationService.authenticate(loginUserDto.getEmail(), loginUserDto.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse(token);
        return ResponseEntity.ok(loginResponse);
    }
}
