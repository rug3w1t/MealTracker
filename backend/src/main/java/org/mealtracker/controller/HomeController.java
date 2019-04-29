package org.mealtracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Day;
import org.mealtracker.model.Note;
import org.mealtracker.repository.NoteRepository;
import org.mealtracker.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    private static Logger LOG = LogManager.getLogger(HomeController.class);

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private DayService dayService;

    @RequestMapping(value = "/", method = GET)
    String home(Model theModel) {

        List<Note> allNotes = noteRepository.findAll();
        List<Day> days = dayService.findAll();
      //  LOG.info("Got all note from db, size : " + allNotes.size());
        theModel.addAttribute("allDays", days);
        theModel.addAttribute("allNotes", allNotes);
        theModel.addAttribute("dayField", new Day());
        theModel.addAttribute("simpleNote", new Note() );


        return "home";
    }



}
