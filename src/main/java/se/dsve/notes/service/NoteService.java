package se.dsve.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.dtos.NoteWithUsernameDto;
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
    // TODO: Implement NoteService
}
