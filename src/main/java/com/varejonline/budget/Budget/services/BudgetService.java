package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAll (){
        return (List<Budget>) budgetRepository.findAll();
    }

    public void save(Budget budget){
        budgetRepository.save(budget);
    }
}
