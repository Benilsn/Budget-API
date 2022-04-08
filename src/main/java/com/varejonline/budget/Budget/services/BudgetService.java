package com.varejonline.budget.Budget.services;

import com.varejonline.budget.Budget.exception.BudgetNotFoundException;
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

    public void save(Budget budget){

        Budget budgetToSave = new Budget();

        budgetToSave.setValidity(budget.getValidity());
        budgetToSave.setClient(new Client(budget.getClient().getName(), budget.getClient().getAddress()));

        budgetRepository.save(budgetToSave);
    }

    public Budget get(Long id) throws BudgetNotFoundException {
        var user = budgetRepository.findById(id);

        if (user.isPresent()){
            return user.get();
        }
        throw new BudgetNotFoundException("Budget with ID: " + id + " not found!");
    }
    
    public void delete(Long id) throws BudgetNotFoundException {
        var count = budgetRepository.countById(id);

        if (count == null || count == 0){
            throw new BudgetNotFoundException("Could not find any budget with ID: "+ id);
        }
        budgetRepository.deleteById(id);
    }


}
