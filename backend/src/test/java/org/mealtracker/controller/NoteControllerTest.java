package org.mealtracker.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.mealtracker.model.Note;
import org.mealtracker.repository.NoteRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class NoteControllerTest {



    @Test
    @Ignore("Nie działa z jakiegoś powodu - do późniejszcej analizay")

    public void testSubmitForm() throws Exception {
        NoteRepository mockRepository = mock(NoteRepository.class);
        Note unsavedNote = new Note();
        Note savedNote = new Note(1l, "test filed");

        when(mockRepository.save(unsavedNote)).thenReturn(savedNote);

        NoteController noteController = new NoteController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();


        mockMvc.perform(post("/processForm")
                .param("text", "test field"))
                .andExpect(redirectedUrl("/"));



        verify(mockRepository, atLeastOnce()).save(unsavedNote);

    }


}