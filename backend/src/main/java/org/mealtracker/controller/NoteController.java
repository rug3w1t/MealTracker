package org.mealtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoteController {

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String saveNote(){
        System.out.println("Inside NoteController : saveNote()");
        return "redirect:/";
    }



}
