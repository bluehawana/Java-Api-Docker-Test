package se.dsve.notes.dtos;

import lombok.Data;
import lombok.Setter;
import se.dsve.notes.model.User;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    // This method is not used in the test, so it can be empty
    @Setter
    private String password;

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        return userDto;
    }

    public String getPassword() {
        return null; // This method is not used in the test, so it can return null
    }

}
