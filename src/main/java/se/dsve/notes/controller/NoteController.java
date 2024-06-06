package se.dsve.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.dtos.NoteWithUsernameDto;
import se.dsve.notes.model.Note;
import se.dsve.notes.service.NoteService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
    // TODO: Implement

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteDto noteDto) {
        // TODO: Implement createNote, the method declaration should not be changed!!!
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        // TODO: Implement getAllNotes, the method declaration should not be changed!!!
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        // TODO: Implement getNoteById, the method declaration should not be changed!!!
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody NoteDto noteDto) {
        // TODO: Implement updateNote, the method declaration should not be changed!!!
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        // TODO: Implement deleteNote, the method declaration should not be changed!!!
        return null;
    }

    @GetMapping("/with-username")
    public ResponseEntity<List<NoteWithUsernameDto>> getAllNotesWithUsername() {
        // TODO: Implement getAllNotesWithUsername, the method declaration should not be changed!!!
        return null;
    }
}
