package org.mealtracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.mealtracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    private static Logger LOG = LogManager.getLogger(HomeController.class);
    @Autowired
    private NoteService noteService;


    @RequestMapping(value = "/", method = GET)
    String home(Model theModel) {

        theModel.addAttribute("note", new Note());
        theModel.addAttribute("allNotes", noteService.findAllForUser(1L) ) ;
        Map<LocalDate, List<Note>> groupedNotesByDate = noteService.findAllForUserAndGroupByDates(1L);
        theModel.addAttribute("groupedNotes",groupedNotesByDate);
        return "home";
    }



}
