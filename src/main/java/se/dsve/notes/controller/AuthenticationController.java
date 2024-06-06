package se.dsve.notes.controller;

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

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterUserDto registerUserDto) {
        // TODO: Implement register, the method declaration should not be changed!!!
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
        // TODO: Implement authenticate, the method declaration should not be changed!!!
        return null;
    }
}
