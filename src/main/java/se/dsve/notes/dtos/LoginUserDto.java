package se.dsve.notes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// TODO: Add Schema & validation annotations
@Data
@NoArgsConstructor
public class LoginUserDto {
    private String email;
    private String password;
}
