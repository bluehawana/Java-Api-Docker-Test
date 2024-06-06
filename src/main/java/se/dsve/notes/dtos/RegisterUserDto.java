package se.dsve.notes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// TODO: Add Schema & validation annotations
@Data
@NoArgsConstructor
public class RegisterUserDto {
    private String fullName;
    private String email;
    private String password;
}
