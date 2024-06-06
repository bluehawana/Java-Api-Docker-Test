package se.dsve.notes.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
