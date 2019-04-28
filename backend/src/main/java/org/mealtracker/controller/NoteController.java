package org.mealtracker.controller;

import org.mealtracker.model.Note;
import org.mealtracker.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    @Autowired
    NoteRepository repository;

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute Note simpleNote){

        System.out.println("Inside NoteController : saveNote() - new note = " + simpleNote.getText());
        repository.save(simpleNote);
        return "redirect:/";
    }



}
