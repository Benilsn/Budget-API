package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
