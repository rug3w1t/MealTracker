package org.mealtracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mealtracker.model.Day;
import org.mealtracker.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DayController {

    private static Logger LOG = LogManager.getLogger(DayController.class);

    @Autowired
    DayService service;


    @RequestMapping(value = "/addDay", method = RequestMethod.POST)
    public String newDay(@ModelAttribute ("dayField")Day day){

        LOG.info("Day added :: description" + day.getDescription());
        service.save(day);
        return "redirect:/";
    }
}
