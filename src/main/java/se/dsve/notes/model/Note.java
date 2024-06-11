package se.dsve.notes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    private String username;

    @ManyToOne
    private User user;

    public void setUser(User user) {
        this.user = user;
        this.username = user.getEmail();
    }

    public void setId(long l) {
        this.id = l;
    }

    public void setUserId(long l) {
        this.user.setId(l);

    }

    // Getters and Setters
}