package se.dsve.notes.dtos;

import lombok.Data;

@Data
public class NoteWithUsernameDto {
    private Long id;
    private String title;
    private String content;
    private String username;
}
