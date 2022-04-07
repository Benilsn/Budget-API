package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.models.client.Client;
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

    public void save(Integer validity, String client_name, String client_address){

        Budget budgetToSave = new Budget();

        budgetToSave.setValidity(validity);
        budgetToSave.setClient(new Client(client_name, client_address));

        budgetRepository.save(budgetToSave);
    }
}
