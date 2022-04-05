package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.models.user.User;
import com.varejonline.budget.Budget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public void login(){

    }
}
