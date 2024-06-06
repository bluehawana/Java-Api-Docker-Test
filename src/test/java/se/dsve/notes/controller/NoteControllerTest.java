package se.dsve.notes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import se.dsve.notes.TestSecurityConfig;
import se.dsve.notes.dtos.NoteDto;
import se.dsve.notes.model.Note;
import se.dsve.notes.service.JwtService;
import se.dsve.notes.service.NoteService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
@Import(TestSecurityConfig.class)
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
    void whenValidInput_thenReturns200() throws Exception {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("New Note Title");
        note.setContent("Content of the new note");
        note.setUserId(1L);

        when(noteService.createNote(any(NoteDto.class))).thenReturn(note);

        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validNoteDto)))
                .andExpect(status().isOk());
    }

    @Test
    void whenMissingTitle_thenReturns400() throws Exception {
        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidNoteDtoMissingTitle)))
                .andExpect(status().isBadRequest());
    }
}
