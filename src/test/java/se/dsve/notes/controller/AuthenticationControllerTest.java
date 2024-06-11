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
import se.dsve.notes.dtos.RegisterUserDto;
import se.dsve.notes.dtos.UserDto;
import se.dsve.notes.model.User;
import se.dsve.notes.service.AuthenticationService;
import se.dsve.notes.service.JwtService;
import se.dsve.notes.service.UserService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
@Import(TestSecurityConfig.class)
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private RegisterUserDto validRegisterUserDto;
    private RegisterUserDto invalidRegisterUserDto;

    @BeforeEach
    void setUp() {
        validRegisterUserDto = new RegisterUserDto();
        validRegisterUserDto.setFullName("Student Studentsson");
        validRegisterUserDto.setEmail("student@example.com");
        validRegisterUserDto.setPassword("SecurePassword123");

        invalidRegisterUserDto = new RegisterUserDto();
        invalidRegisterUserDto.setFullName("Student Studentsson");
        invalidRegisterUserDto.setEmail("invalid-email-format");
        invalidRegisterUserDto.setPassword("SecurePassword123");
    }

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setFullName("Student Studentsson");
        userDto.setEmail("student@example.com");

        when(userService.registerUser(any(UserDto.class))).thenReturn(userDto);

        mockMvc.perform(post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRegisterUserDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
    }


    @Test
    void whenInvalidEmail_thenReturns400() throws Exception {
        mockMvc.perform(post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRegisterUserDto)))
                .andExpect(status().isBadRequest());
    }
}
