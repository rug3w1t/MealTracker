package org.mealtracker.controller;

import org.junit.Test;
import org.mealtracker.model.Note;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class NoteControllerTest {


    @Test
    public void testSubmitForm() throws Exception {
        Note note = new Note(1l, "test filed");
        NoteController noteController = new NoteController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(NoteController.class).build();

        mockMvc.perform(post("/processForm"))
                .andExpect(redirectedUrl("/"));

    }

}