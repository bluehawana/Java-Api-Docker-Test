package se.dsve.notes.dtos;

import lombok.Data;
import lombok.Setter;
import se.dsve.notes.model.User;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String password;

    public UserDto() {
    }

    public UserDto(Long id, String fullName, String email, LocalDateTime createdAt, LocalDateTime updatedAt, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.password = password;
    }

    public UserDto(Long id, String fullName, String email, Date createdAt, Date updatedAt, String password) {
    }

    public static UserDto fromUser(User user) {
        return new UserDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getPassword()
        );
    }

    // Getters and setters
    // ...
}
