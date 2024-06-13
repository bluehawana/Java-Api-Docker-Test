package se.dsve.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.model.Note;
import se.dsve.notes.model.User;
import se.dsve.notes.repository.NoteRepository;
import se.dsve.notes.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public List<Note> getAllNotes() {
    return StreamSupport.stream(noteRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Note createNote(NoteDto noteDto) {
        Optional<User> optionalUser = userRepository.findById(noteDto.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Note note = new Note();
            note.setTitle(noteDto.getTitle());
            note.setContent(noteDto.getContent());
            note.setUser(user);
            return noteRepository.save(note);
        }
        return null;
    }

    public boolean deleteNote(Long id) {
        Optional <Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            noteRepository.delete(optionalNote.get());
            return true;
        }
        return false;
    }

    public List<Note> getAllNotesWithUsername() {
        String username = "";
        return noteRepository.findAllByUser_Email(username);
    }

    public Note getNoteById(Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        return optionalNote.orElse(null);
    }

    public Note updateNote(Long id, NoteDto noteDto) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(noteDto.getTitle());
            note.setContent(noteDto.getContent());
            return noteRepository.save(note);
        }
        return null;
    }
    // TODO: Implement NoteService
}

