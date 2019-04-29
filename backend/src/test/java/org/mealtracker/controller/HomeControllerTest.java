package org.mealtracker.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
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
    public void testRootHomeAndExpectHomeViewName() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }


}