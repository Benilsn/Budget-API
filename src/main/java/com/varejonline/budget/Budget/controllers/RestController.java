package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void add(@RequestBody Budget budget){
        budgetService.save(budget);
    }
}
