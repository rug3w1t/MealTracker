package org.mealtracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoteController {

    private static  Logger LOG = LogManager.getLogger(NoteController.class);

    @Autowired
    private NoteRepository repository;

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute("simpleNote") Note simpleNote){

        LOG.info("Inside NoteController : saveNote() - new note = " + simpleNote.getTextFiled());
        repository.save(simpleNote);
        return "redirect:/";
    }



}
