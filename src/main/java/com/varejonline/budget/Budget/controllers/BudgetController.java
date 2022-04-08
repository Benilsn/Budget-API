package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/budgets")
    public String showBudgetsList(Model model){

        List<Budget> budgetsList = budgetService.getAll();
        model.addAttribute("budgetsList", budgetsList);

        return "read";
    }
}
