package org.mealtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeContorller {

    @RequestMapping(value = "/", method = GET)
    String home() {
        return "home";
    }
}
