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
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteDto noteDto) {
        Note createdNote = noteService.createNote(noteDto);
        if (createdNote == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(noteService.createNote(noteDto));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.getAllNotes();
        return ResponseEntity.ok(allNotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody NoteDto noteDto) {
        Note updatedNote = noteService.updateNote(id, noteDto);
        if (updatedNote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNote(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/with-username")
    public ResponseEntity<List<Note>> getAllNotesWithUsername() {
        List<Note> allNotesWithUsername = noteService.getAllNotesWithUsername();
        return ResponseEntity.ok(allNotesWithUsername);
    }
}