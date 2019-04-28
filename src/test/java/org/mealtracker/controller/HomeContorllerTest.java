package org.mealtracker.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class HomeContorllerTest {

    /*
    * Prosty test zwracania nazwy widoku
    * */
    @Test
    public void testHomePageSimple(){
        HomeContorller homeContorller = new HomeContorller();
        assertEquals("home", homeContorller.home() );
    }

    @Test
    public void testRootHomeAndExpectHomeViewName() throws Exception {
        HomeContorller homeContorller = new HomeContorller();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeContorller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}