package se.dsve.notes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// TODO: Add Schema & validation annotations
@Data
@NoArgsConstructor
public class NoteDto {
    @NotBlank(message = "Title is required")
    private String title;
    private String content;
    private Long userId;
}
