package se.dsve.notes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.model.Note;
import se.dsve.notes.service.JwtService;
import se.dsve.notes.service.NoteService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    private NoteDto validNoteDto;
    private NoteDto invalidNoteDtoMissingTitle;

    @BeforeEach
    void setUp() {
        validNoteDto = new NoteDto();
        validNoteDto.setTitle("New Note Title");
        validNoteDto.setContent("Content of the new note");
        validNoteDto.setUserId(1L);

        invalidNoteDtoMissingTitle = new NoteDto();
        invalidNoteDtoMissingTitle.setContent("Content of the new note");
        invalidNoteDtoMissingTitle.setUserId(1L);
    }

    @Test
    void whenValidInput_thenReturns201() throws Exception {
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle("New Note Title");
        noteDto.setContent("Content of the new note");
        noteDto.setUserId(1L);

        Note createdNote = new Note();
        createdNote.setId(1L);
        createdNote.setTitle(noteDto.getTitle());
        createdNote.setContent(noteDto.getContent());
        createdNote.setUserId(noteDto.getUserId());

        when(noteService.createNote(any(NoteDto.class))).thenReturn(createdNote);

        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(noteDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenMissingTitle_thenReturns400() throws Exception {
        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidNoteDtoMissingTitle)))
                .andExpect(status().isBadRequest());
    }
}
