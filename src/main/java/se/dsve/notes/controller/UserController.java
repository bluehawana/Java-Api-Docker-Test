package se.dsve.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dsve.notes.dtos.UserDto;
import se.dsve.notes.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    // TODO: Implement UserController
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // TODO: Implement getAllUsers, the method declaration should not be changed!!!
        return null;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email) {
        // TODO: Implement findUserByEmail, the method declaration should not be changed!!!
        return null;
    }
}
