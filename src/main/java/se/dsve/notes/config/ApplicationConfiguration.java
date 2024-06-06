package se.dsve.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import se.dsve.notes.repository.UserRepository;

@Configuration
public class ApplicationConfiguration {

    private final UserRepository userRepository;

    public ApplicationConfiguration(UserRepository userRepository) {
        // TODO: Implement constructor
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // TODO: Implement userDetailsService
        return null;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // TODO: Implement passwordEncoder
        return null;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        // TODO: Implement authenticationManager
        return null;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // TODO: Implement authenticationProvider
        return null;
    }
}
