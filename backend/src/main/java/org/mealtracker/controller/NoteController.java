package org.mealtracker.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    private static Logger LOG = LogManager.getLogger(NoteController.class);


    @PostMapping("/addNote")
    public String createNewNote(@ModelAttribute Note newNote){

        LOG.info("Adding new note id :: " + newNote.getId() );

        return "redirect:/";

    }


}

