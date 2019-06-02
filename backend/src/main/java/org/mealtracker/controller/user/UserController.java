package org.mealtracker.controller.user;

import org.mealtracker.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public String showUsers(Model model){

        model.addAttribute("users", service.findAll());

        return "users";
    }


}
