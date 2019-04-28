package org.mealtracker.controller;

public class NoteControllerTest {



    /*@Test
    public void testSubmitForm() throws Exception {
        NoteRepository mockRepository = mock(NoteRepository.class);
        Note unsavedNote = new Note("test field");
        Note savedNote = new Note(1l, "test filed");

        when(mockRepository.save(unsavedNote)).thenReturn(savedNote);

        NoteController noteController = new NoteController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();


        mockMvc.perform(post("/processForm")
                .param("text", "test field"))
                .andExpect(redirectedUrl("/"));



        verify(mockRepository, atLeastOnce()).save(unsavedNote);

    }*/


}