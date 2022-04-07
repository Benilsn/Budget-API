package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private BudgetService budgetService;


    @GetMapping("/budgets")
    public List<Budget> getAll(){
        return budgetService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestParam(name = "validity") Integer validity,
                            @RequestParam(name = "client_name") String client_name,
                            @RequestParam(name = "client_address") String client_address){

        budgetService.save(validity, client_name, client_address);

    }
}
