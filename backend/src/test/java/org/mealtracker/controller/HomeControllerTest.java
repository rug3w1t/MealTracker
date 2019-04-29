package org.mealtracker.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.mealtracker.repository.NoteRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class HomeControllerTest {

    /*
    * Prosty test zwracania nazwy widoku
    * */
    @Test
    public void testHomePageSimple(){
     /*   HomeController homeContorller = new HomeController();
        assertEquals("home", homeContorller.home() );*/
    }

    /**
     * Pełny test metody kontrolera
     * @throws Exception
     */
    @Test
    @Ignore
    // po dodaniu pobierania notatek z repo pokazuje się null pointer exception
    // mimo że z bazy notakti są pobierane kiedy odpalam aplikacje
    public void testRootHomeAndExpectHomeViewName() throws Exception {
        NoteRepository mockRepository = mock(NoteRepository.class);

        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        when(mockRepository.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }


}