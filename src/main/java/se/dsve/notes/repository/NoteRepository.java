package se.dsve.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dsve.notes.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
