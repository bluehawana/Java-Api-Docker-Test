package se.dsve.notes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import se.dsve.notes.TestSecurityConfig;
import se.dsve.notes.dtos.UserDto;
import se.dsve.notes.service.JwtService;
import se.dsve.notes.service.UserService;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(TestSecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setFullName("Student Studentsson");
        userDto.setEmail("student@example.com");
    }

    @Test
    void getAllUsers_returns200() throws Exception {
        when(userService.findAllUsers()).thenReturn(Collections.singletonList(userDto));

        mockMvc.perform(get("/users/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(userDto))));
    }

    @Test
    void findUserByEmail_validEmail_returns200() throws Exception {
        when(userService.findUserByEmail(anyString())).thenReturn(Optional.of(userDto));

        mockMvc.perform(get("/users/student@example.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
    }

    @Test
    void findUserByEmail_invalidEmail_returns404() throws Exception {
        when(userService.findUserByEmail(anyString())).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/nonexistent@example.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
