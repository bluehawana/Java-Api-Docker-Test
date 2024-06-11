package se.dsve.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dsve.notes.dtos.NoteWithUsernameDto;
import se.dsve.notes.model.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUsername(String username);
}
