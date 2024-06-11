package se.dsve.notes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.model.Note;
import se.dsve.notes.service.NoteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    // TODO: Implement
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteDto noteDto) {
        // TODO: Implement createNote, the method declaration should not be changed!!!
        Note createNote = noteService.createNote(noteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createNote);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        // TODO: Implement getAllNotes, the method declaration should not be changed!!!
        List<Note> allNotes = noteService.getAllNotes();
        return ResponseEntity.ok(allNotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        // TODO: Implement getNoteById, the method declaration should not be changed!!!
        Note note = noteService.getNoteById(id);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody NoteDto noteDto) {
        // TODO: Implement updateNote, the method declaration should not be changed!!!
        Note updatedNote = noteService.updateNote(id, noteDto);
        if (updatedNote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        // TODO: Implement deleteNote, the method declaration should not be changed!!!
        boolean deleted = noteService.deleteNote(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/with-username")
    public ResponseEntity<List<Note>> getAllNotesWithUsername() {
        // TODO: Implement getAllNotesWithUsername, the method declaration should not be changed!!!
        List<Note> allNotesWithUsername = noteService.getAllNotesWithUsername();
        return ResponseEntity.ok(allNotesWithUsername);
    }
}