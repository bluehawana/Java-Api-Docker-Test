package se.dsve.notes.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.dsve.notes.dtos.LoginUserDto;
import se.dsve.notes.dtos.RegisterUserDto;
import se.dsve.notes.model.User;
import se.dsve.notes.repository.UserRepository;

@Service
public class AuthenticationService {
    // TODO: Implement AuthenticationService
}
