package org.mealtracker.controller;

import org.mealtracker.model.dto.NoteDto;
import org.mealtracker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String getTestPage(Model model){
        NoteDto note = noteService.findOneById(5L);
        model.addAttribute("testNote" , note);
        List<NoteDto> noteDtos = noteService.findAllForUser(1l);
        model.addAttribute("noteDtos", noteDtos);
        return "test";
    }
}
