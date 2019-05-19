package org.mealtracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    private static Logger LOG = LogManager.getLogger(HomeController.class);



    @RequestMapping(value = "/", method = GET)
    String home(Model theModel) {

        theModel.addAttribute("note", new Note());

        return "home";
    }



}
