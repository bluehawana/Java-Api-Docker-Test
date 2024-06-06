package se.dsve.notes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Add Schema
@Data
@NoArgsConstructor
public class BaseUserDto {
    private String email;
    private String password;
}
