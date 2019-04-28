package org.mealtracker.controller;

import org.mealtracker.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeContorller {

    @RequestMapping(value = "/", method = GET)
    String home(Model theModel) {
        theModel.addAttribute("simpleNote", new Note());
        return "home";
    }
}
